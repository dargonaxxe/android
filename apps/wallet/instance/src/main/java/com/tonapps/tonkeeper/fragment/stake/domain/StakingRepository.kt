package com.tonapps.tonkeeper.fragment.stake.domain

import com.tonapps.blockchain.Coin
import com.tonapps.tonkeeper.fragment.stake.data.mapper.StakingServiceMapper
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakedBalance
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingPoolLiquidJetton
import com.tonapps.tonkeeper.fragment.stake.domain.model.maxAPY
import com.tonapps.tonkeeper.fragment.swap.domain.DexAssetsRepository
import com.tonapps.wallet.api.API
import com.tonapps.wallet.data.core.WalletCurrency
import com.tonapps.wallet.data.rates.RatesRepository
import com.tonapps.wallet.data.rates.entity.RateEntity
import io.tonapi.models.PoolImplementationType
import io.tonapi.models.PoolInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import org.ton.block.MsgAddressInt

class StakingRepository(
    private val api: API,
    private val mapper: StakingServiceMapper,
    private val ratesRepository: RatesRepository,
    private val dexAssetsRepository: DexAssetsRepository
) {

    private val _stakedBalances = MutableStateFlow<List<StakedBalance>>(emptyList())
    val stakedBalance: Flow<List<StakedBalance>>
        get() = _stakedBalances

    // todo add caching
    suspend fun getStakingPools(
        accountId: String,
        testnet: Boolean
    ) = withContext(Dispatchers.IO) {
        val result = api.getStakingPools(accountId, testnet)
        val implementationsByPool = PoolImplementationType.entries
            .associateWith { mutableSetOf<PoolInfo>() }

        result.pools.forEach { pool ->
            implementationsByPool[pool.implementation]?.add(pool)
        }

        implementationsByPool.asSequence()
            .filter { it.value.isNotEmpty() }
            .map { mapper.map(it, result.implementations) }
            .sortedByDescending { it.maxAPY }
            .mapIndexed { index1, item1 ->
                if (index1 == 0) {
                    item1.copy(
                        pools = item1.pools.mapIndexed { index, item ->
                            if (index == 0) {
                                item.copy(isMaxApy = true)
                            } else {
                                item
                            }
                        }
                    )
                } else {
                    item1
                }
            }
            .toList()
    }

    suspend fun getJetton(
        masterAddress: String,
        poolName: String,
        currency: WalletCurrency,
        testnet: Boolean
    ): StakingPoolLiquidJetton = withContext(Dispatchers.IO) {
        val deferredJettonInfo = async { api.jettons(testnet).getJettonInfo(masterAddress) }
        val deferredRate = async { getRate(currency, masterAddress) }
        val jettonInfo = deferredJettonInfo.await()
        val rate = deferredRate.await()


        StakingPoolLiquidJetton(
            address = masterAddress,
            iconUrl = jettonInfo.metadata.image ?: "",
            symbol = jettonInfo.metadata.symbol,
            price = rate?.value,
            poolName = poolName,
            currency = currency
        )
    }

    private suspend fun getRate(
        currency: WalletCurrency,
        masterAddress: String
    ): RateEntity? {
        val cachedValue = ratesRepository.cache(currency, listOf(masterAddress))
            .rate(masterAddress)
        return cachedValue ?: ratesRepository.getRates(currency, masterAddress)
            .rate(masterAddress)
    }

    suspend fun loadStakedBalances(
        walletAddress: String,
        testnet: Boolean
    ) = withContext(Dispatchers.IO) {
        val nominatorsDeferred = async {
            api.staking(testnet).getAccountNominatorsPools(walletAddress)
        }
        val poolsDeferred = async {
            getStakingPools(walletAddress, testnet)
        }
        val jettonBalancesDeferred = async {
            dexAssetsRepository.isLoading.filter { !it }
                .first()
            dexAssetsRepository.positiveBalance.first()
        }
        val nominators = nominatorsDeferred.await()
        val stakingServices = poolsDeferred.await()
        val pools = stakingServices.flatMap { it.pools }
        val jettonBalances = jettonBalancesDeferred.await()
        val poolsWithJettons = pools.filter { it.liquidJettonMaster != null }
        val liquidStaking = poolsWithJettons.mapNotNull { poolWithJetton ->
            val liquidJettonAddressParsed = MsgAddressInt.parse(poolWithJetton.liquidJettonMaster!!)
            val jetton = jettonBalances.firstOrNull {
                liquidJettonAddressParsed.isAddressEqual(it.contractAddress)
            }
            if (jetton == null) {
                null
            } else {
                StakedBalance(
                    poolWithJetton,
                    stakingServices.first { it.type == poolWithJetton.serviceType },
                    balance = jetton.balance,
                    asset = jetton
                )
            }
        }
        val normalStaking = nominators.pools.mapNotNull { stakingInfo ->
            val pool = pools.firstOrNull { it.name == stakingInfo.pool } ?: return@mapNotNull null
            StakedBalance(
                pool = pool,
                service = stakingServices.first { it.type == pool.serviceType },
                balance = stakingInfo.amount.toBigDecimal().movePointLeft(Coin.TON_DECIMALS),
                asset = null
            )
        }
        _stakedBalances.value = liquidStaking + normalStaking
    }
}

fun String.isAddressEqual(another: String): Boolean {
    return MsgAddressInt.parse(this).isAddressEqual(another)
}

fun MsgAddressInt.isAddressEqual(another: String): Boolean {
    return this == MsgAddressInt.parse(another)
}