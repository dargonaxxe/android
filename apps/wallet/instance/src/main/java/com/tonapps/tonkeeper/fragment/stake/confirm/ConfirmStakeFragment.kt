package com.tonapps.tonkeeper.fragment.stake.confirm

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.tonapps.tonkeeper.extensions.popBackToRootFragment
import com.tonapps.tonkeeper.fragment.stake.confirm.rv.ConfirmStakeAdapter
import com.tonapps.tonkeeper.fragment.stake.domain.StakingTransactionType
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingPool
import com.tonapps.tonkeeper.fragment.stake.root.StakeFragment
import com.tonapps.tonkeeperx.R
import core.extensions.observeFlow
import uikit.base.BaseFragment
import uikit.widget.HeaderView
import org.koin.androidx.viewmodel.ext.android.viewModel
import uikit.extensions.applyNavBottomPadding
import uikit.extensions.dp
import uikit.widget.ProcessTaskView
import uikit.widget.SlideActionView

class ConfirmStakeFragment : BaseFragment(R.layout.fragment_confirm_stake), BaseFragment.BottomSheet {

    companion object {
        fun newInstance(
            pool: StakingPool,
            amount: Float,
            type: StakingTransactionType
        ) = ConfirmStakeFragment().apply {
            setArgs(
                ConfirmStakeArgs(pool, amount, type)
            )
        }
    }

    // todo add circle cropping for icons
    private val viewModel: ConfirmStakeViewModel by viewModel()
    private val header: HeaderView?
        get() = view?.findViewById(R.id.fragment_confirm_stake_header)
    private val icon: ImageView?
        get() = view?.findViewById(R.id.fragment_confirm_stake_icon)
    private val operationTextView: TextView?
        get() = view?.findViewById(R.id.fragment_confirm_stake_operation)
    private val amountCryptoTextView: TextView?
        get() = view?.findViewById(R.id.fragment_confirm_stake_amount_crypto)
    private val amountFiatTextView: TextView?
        get() = view?.findViewById(R.id.fragment_confirm_stake_amount_fiat)
    private val recyclerView: RecyclerView?
        get() = view?.findViewById(R.id.fragment_confirm_stake_rv)
    private val adapter = ConfirmStakeAdapter()
    private val slider: SlideActionView?
        get() = view?.findViewById(R.id.fragment_confirm_stake_slider)
    private val footer: View?
        get() = view?.findViewById(R.id.fragment_confirm_stake_footer)
    private val processView: ProcessTaskView?
        get() = view?.findViewById(R.id.fragment_confirm_stake_process_view)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.provideArgs(
                ConfirmStakeArgs(
                    requireArguments()
                )
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        header?.doOnActionClick = { viewModel.onCrossClicked() }
        header?.doOnCloseClick = { viewModel.onChevronClicked() }

        recyclerView?.adapter = adapter

        slider?.doOnDone = { viewModel.onSliderDone() }

        footer?.applyNavBottomPadding(16f.dp)

        observeFlow(viewModel.events) { handleEvent(it) }
        observeFlow(viewModel.icon) { icon?.setImageResource(it) }
        observeFlow(viewModel.operationText) { operationTextView?.setText(it) }
        observeFlow(viewModel.amountCryptoText) { amountCryptoTextView?.text = it }
        observeFlow(viewModel.amountFiatText) { amountFiatTextView?.text = it }
        observeFlow(viewModel.items) { adapter.submitList(it) }
        observeFlow(viewModel.isSliderVisible) { slider?.isVisible = it }
        observeFlow(viewModel.isProcessViewVisible) { processView?.isVisible = it }
        observeFlow(viewModel.processViewState) { processView?.state = it }
    }

    private fun handleEvent(event: ConfirmStakeEvent) {
        when (event) {
            is ConfirmStakeEvent.CloseFlow -> event.handle()
            ConfirmStakeEvent.NavigateBack -> finish()
            is ConfirmStakeEvent.RestartSlider -> event.handle()
        }
    }

    private fun ConfirmStakeEvent.RestartSlider.handle() {
        slider?.reset()
        processView
    }

    private fun ConfirmStakeEvent.CloseFlow.handle() {
        popBackToRootFragment(
            true,
            StakeFragment::class
        )
        finish()
    }
}