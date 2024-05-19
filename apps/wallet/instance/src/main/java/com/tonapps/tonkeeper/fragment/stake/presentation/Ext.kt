package com.tonapps.tonkeeper.fragment.stake.presentation

import com.tonapps.blockchain.Coin
import com.tonapps.icu.CurrencyFormatter
import com.tonapps.tonkeeper.core.TextWrapper
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingPool
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingServiceType
import com.tonapps.tonkeeper.fragment.stake.root.StakeViewModel
import com.tonapps.wallet.localization.R
import java.math.BigDecimal

fun StakingServiceType.getIconUrl() = "res:/${getIconDrawableRes()}"

fun StakingServiceType.getIconDrawableRes(): Int {
    return when (this) {
        StakingServiceType.TF -> com.tonapps.tonkeeperx.R.drawable.ic_staking_tf
        StakingServiceType.WHALES -> com.tonapps.tonkeeperx.R.drawable.ic_staking_whales
        StakingServiceType.LIQUID_TF -> com.tonapps.tonkeeperx.R.drawable.ic_staking_tonstakers
    }
}



fun Long.formatTon(): String {
    val minStaking = BigDecimal(this).movePointLeft(Coin.TON_DECIMALS)
    return CurrencyFormatter.format(StakeViewModel.TOKEN_TON, minStaking).toString()
}

fun StakingPool.minStakingText(): String {
    return minStake.formatTon()
}

fun StakingPool.description(): TextWrapper {
    val apy = formatApy()
    val minStakingString = minStakingText()
    return TextWrapper.StringResource(R.string.staking_pool_description_mask, apy, minStakingString)
}

fun StakingPool.apyText(): TextWrapper {
    val apy = formatApy()
    return TextWrapper.StringResource(R.string.apy_mask, apy)
}

fun StakingPool.formatApy(): String {
    return CurrencyFormatter.format(
        apy,
        2
    )
}