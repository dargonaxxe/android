package com.tonapps.tonkeeper.fragment.stake.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import coil.transform.RoundedCornersTransformation
import com.tonapps.icu.CurrencyFormatter
import com.tonapps.tonkeeper.core.loadUri
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingPoolLiquidJetton
import com.tonapps.tonkeeperx.R
import uikit.extensions.dp
import uikit.widget.ColumnLayout

class LiquidStakingDetailsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : ColumnLayout(context, attrs, defStyle){

    private val icon: ImageView?
        get() = findViewById(R.id.view_liquid_staking_details_icon)
    private val title: TextView?
        get() = findViewById(R.id.view_liquid_staking_details_title)
    private val subtitle: TextView?
        get() = findViewById(R.id.view_liquid_staking_details_subtitle)
    private val description: TextView?
        get() = findViewById(R.id.view_liquid_staking_details_description)
    init {
        inflate(context, R.layout.view_liquid_staking_details, this)
        isVisible = false
    }

    fun applyLiquidJetton(liquidJetton: StakingPoolLiquidJetton?) {

        isVisible = liquidJetton != null
        liquidJetton ?: return
        icon?.loadUri(liquidJetton.iconUri, RoundedCornersTransformation(24f.dp))
        title?.text = liquidJetton.symbol
        liquidJetton.price?.let {
            subtitle?.text = CurrencyFormatter.format(
                liquidJetton.currency.code,
                liquidJetton.price
            )
        }
        description?.text = resources.getString(
            com.tonapps.wallet.localization.R.string.liquid_staking_description,
            liquidJetton.poolName,
            liquidJetton.symbol,
            liquidJetton.symbol
        )
    }
}