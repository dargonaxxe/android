package com.tonapps.tonkeeper.fragment.stake.domain

import com.tonapps.tonkeeper.extensions.emulate
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingPool
import com.tonapps.tonkeeper.fragment.stake.domain.model.addStakeCellProducer
import com.tonapps.wallet.api.API
import com.tonapps.wallet.data.account.legacy.WalletLegacy
import io.tonapi.models.MessageConsequences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmulateStakingCase(
    private val getStakeWalletTransferCase: GetStakeWalletTransferCase,
    private val api: API
) {

    suspend fun execute(
        walletLegacy: WalletLegacy,
        pool: StakingPool,
        amount: Float
    ): MessageConsequences = withContext(Dispatchers.IO) {
        val cell = pool.serviceType.addStakeCellProducer.produce()
        val walletTransfer = getStakeWalletTransferCase.getWalletTransfer(
            walletLegacy,
            pool,
            amount,
            cell
        )
        walletLegacy.emulate(api, walletTransfer)
    }
}