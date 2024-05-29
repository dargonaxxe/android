package com.tonapps.tonkeeper.fragment.swap.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.tonapps.icu.CurrencyFormatter
import com.tonapps.tonkeeper.fragment.swap.domain.model.SwapSimulation
import com.tonapps.tonkeeper.fragment.swap.info.InfoArgs
import com.tonapps.tonkeeper.fragment.swap.info.InfoFragment
import com.tonapps.tonkeeperx.R
import uikit.extensions.setThrottleClickListener
import uikit.navigation.Navigation.Companion.navigation
import uikit.widget.ProcessTaskView
import java.math.BigDecimal

class SwapDetailsView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(context, attrs, defStyle) {

    private val loader: ProcessTaskView?
        get() = findViewById(R.id.view_swap_details_loader)
    private val detailsGroup: View?
        get() = findViewById(R.id.view_swap_details_details)
    private val rateTitle: TextView?
        get() = findViewById(R.id.view_swap_details_rate_title)
    private val rateValue: TextView?
        get() = findViewById(R.id.view_swap_details_rate_value)
    private val minReceived: TextView?
        get() = findViewById(R.id.view_swap_details_min_received)
    private val liquidityProviderFeeTextView: TextView?
        get() = findViewById(R.id.view_swap_details_liquidity_provider_fee)
    private val blockchainFeeTextView: TextView?
        get() = findViewById(R.id.view_swap_details_blockchain_fee)
    private val priceImpactTextView: TextView?
        get() = findViewById(R.id.view_swap_details_price_impact)
    private val routeTextView: TextView?
        get() = findViewById(R.id.view_swap_details_route)
    private val priceImpactInfoButton: View?
        get() = findViewById(R.id.view_swap_details_info_price_impact)
    private val minReceivedInfoButton: View?
        get() = findViewById(R.id.view_swap_details_info_min_received)
    private val liquidityProviderFeeInfoButton: View?
        get() = findViewById(R.id.view_swap_details_info_liquidity_provider_fee)

    init {
        inflate(context, R.layout.view_swap_details, this)
        priceImpactInfoButton?.setThrottleClickListener {
            with(context) {
                val fragment = InfoFragment.newInstance(InfoArgs.priceImpact(this))
                navigation?.add(fragment)
            }
        }
        minReceivedInfoButton?.setThrottleClickListener {
            with(context) {
                val fragment = InfoFragment.newInstance(InfoArgs.minReceived(this))
                navigation?.add(fragment)
            }
        }
        liquidityProviderFeeInfoButton?.setThrottleClickListener {
            with(context) {
                val fragment = InfoFragment.newInstance(InfoArgs.liquidityProviderFee(this))
                navigation?.add(fragment)
            }
        }
    }

    fun updateState(simulation: SwapSimulation?) {
        simulation.updateSimulation()
    }

    private fun SwapSimulation?.updateSimulation() {
        isVisible = this != null
        when (this) {
            SwapSimulation.Loading -> {
                loader?.isVisible = true
                detailsGroup?.isVisible = false
            }

            is SwapSimulation.Result -> {
                loader?.isVisible = false
                detailsGroup?.isVisible = true
                rateTitle?.text = CurrencyFormatter.format(
                    sentAsset.symbol,
                    BigDecimal.ONE
                )
                rateValue?.text = CurrencyFormatter.format(
                    receivedAsset.symbol,
                    exchangeRate
                )
                minReceived?.text = CurrencyFormatter.format(
                    receivedAsset.symbol,
                    minimumReceivedAmount
                )
                liquidityProviderFeeTextView?.text = CurrencyFormatter.format(
                    receivedAsset.symbol,
                    liquidityProviderFee
                )
                blockchainFeeTextView?.text = CurrencyFormatter.format(
                    "TON",
                    blockchainFee
                )
                priceImpactTextView?.text = priceImpact.movePointRight(2)
                    .toPlainString()
                    .let { "$it%" }
                routeTextView?.text = "${sentAsset.symbol} >> ${receivedAsset.symbol}"
            }

            null -> Unit
        }
    }
}