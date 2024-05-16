package com.tonapps.tonkeeper.fragment.stake.confirm

import com.tonapps.tonkeeper.core.TextWrapper
import com.tonapps.tonkeeper.fragment.stake.confirm.rv.ConfirmStakeItemType
import com.tonapps.tonkeeper.fragment.stake.confirm.rv.ConfirmStakeListItem
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingPool
import com.tonapps.tonkeeper.fragment.stake.presentation.formatApy
import com.tonapps.uikit.list.ListCell
import com.tonapps.wallet.data.account.entities.WalletEntity
import com.tonapps.wallet.localization.R as LocalizationR

class ConfirmStakeListItemMapper {
    private val listSize = ConfirmStakeItemType.entries.size
    fun map(
        type: ConfirmStakeItemType,
        wallet: WalletEntity,
        pool: StakingPool
    ): ConfirmStakeListItem {
        return when (type) {
            ConfirmStakeItemType.WALLET -> buildWalletItem(wallet)
            ConfirmStakeItemType.RECIPIENT -> buildRecipientItem(pool)
            ConfirmStakeItemType.APY -> buildAPYItem(pool)
            ConfirmStakeItemType.FEE -> buildFeeItem()
        }
    }

    private fun buildWalletItem(wallet: WalletEntity): ConfirmStakeListItem {
        return ConfirmStakeListItem(
            name = TextWrapper.StringResource(LocalizationR.string.wallet),
            textPrimary = TextWrapper.PlainString(
                "${wallet.label.emoji} ${wallet.label.name}"
            ),
            position = ListCell.getPosition(
                listSize,
                ConfirmStakeItemType.WALLET.ordinal
            )
        )
    }

    private fun buildRecipientItem(pool: StakingPool): ConfirmStakeListItem {
        return ConfirmStakeListItem(
            name = TextWrapper.StringResource(LocalizationR.string.recipient),
            textPrimary = TextWrapper.PlainString(
                pool.name
            ),
            position = ListCell.getPosition(
                listSize,
                ConfirmStakeItemType.RECIPIENT.ordinal
            )
        )
    }

    private fun buildAPYItem(pool: StakingPool): ConfirmStakeListItem {
        return ConfirmStakeListItem(
            name = TextWrapper.StringResource(LocalizationR.string.apy),
            textPrimary = TextWrapper.StringResource(
                LocalizationR.string.apy_mask,
                pool.formatApy(),
            ),
            position = ListCell.getPosition(
                listSize,
                ConfirmStakeItemType.APY.ordinal
            )
        )
    }

    // todo
    private fun buildFeeItem(): ConfirmStakeListItem {
        return ConfirmStakeListItem(
            name = TextWrapper.StringResource(LocalizationR.string.fee),
            textPrimary = TextWrapper.PlainString("todo",),
            textSecondary = "todo",
            position = ListCell.getPosition(
                listSize,
                ConfirmStakeItemType.FEE.ordinal
            )
        )
    }
}