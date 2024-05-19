package com.tonapps.tonkeeper.fragment.stake.root

import com.tonapps.tonkeeper.fragment.stake.domain.StakingTransactionType
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingPool
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingService
import java.math.BigDecimal

sealed class StakeEvent {
    object NavigateBack : StakeEvent()
    object ShowInfo : StakeEvent()
    data class SetInputValue(val value: BigDecimal) : StakeEvent()
    data class PickStakingOption(
        val items: List<StakingService>,
        val picked: StakingPool
    ) : StakeEvent()
    data class NavigateToConfirmFragment(
        val pool: StakingPool,
        val amount: BigDecimal,
        val type: StakingTransactionType
    ) : StakeEvent()
}