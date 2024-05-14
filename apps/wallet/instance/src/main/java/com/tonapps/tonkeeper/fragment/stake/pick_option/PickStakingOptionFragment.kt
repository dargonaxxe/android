package com.tonapps.tonkeeper.fragment.stake.pick_option

import android.os.Bundle
import android.util.Log
import android.view.View
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingPool
import com.tonapps.tonkeeper.fragment.stake.domain.model.StakingService
import com.tonapps.tonkeeper.fragment.stake.pick_option.rv.StakingOptionAdapter
import com.tonapps.tonkeeper.fragment.stake.pick_pool.PickPoolFragment
import com.tonapps.tonkeeper.fragment.stake.pool_details.PoolDetailsFragment
import com.tonapps.uikit.icon.UIKitIcon
import core.extensions.observeFlow
import org.koin.androidx.viewmodel.ext.android.viewModel
import uikit.base.BaseFragment
import uikit.base.BaseListFragment
import uikit.navigation.Navigation.Companion.navigation
import com.tonapps.wallet.localization.R as LocalizationR

class PickStakingOptionFragment : BaseListFragment(), BaseFragment.BottomSheet {

    companion object {
        fun newInstance(
            options: List<StakingService>,
            picked: StakingPool
        ) = PickStakingOptionFragment().apply {
            setArgs(
                PickStakingOptionFragmentArgs(options, picked)
            )
        }
    }

    private val viewModel: PickStakingOptionViewModel by viewModel()
    private val adapter = StakingOptionAdapter { viewModel.onItemClicked(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.provideArgs(PickStakingOptionFragmentArgs(requireArguments()))
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        headerView.doOnCloseClick = { viewModel.onChevronClicked() }
        headerView.doOnActionClick = { viewModel.onCrossClicked() }
        headerView.setIcon(UIKitIcon.ic_chevron_left_16)
        setTitle(getString(LocalizationR.string.options))

        setAdapter(adapter)

        observeFlow(viewModel.events) { handleEvent(it) }
        observeFlow(viewModel.items) { list ->
            adapter.submitList(list)
        }
    }

    private fun handleEvent(event: PickStakingOptionEvent) {
        when (event) {
            PickStakingOptionEvent.CloseFlow -> Log.wtf("###", "closeFlow")
            PickStakingOptionEvent.NavigateBack -> finish()
            is PickStakingOptionEvent.ShowPoolPicker -> event.handle()
            is PickStakingOptionEvent.ShowPoolDetails -> event.handle()
        }
    }

    private fun PickStakingOptionEvent.ShowPoolPicker.handle() {
        val fragment = PickPoolFragment.newInstance(service, pickedPool)
        navigation?.add(fragment)
    }

    private fun PickStakingOptionEvent.ShowPoolDetails.handle() {
        val fragment = PoolDetailsFragment.newInstance(service, pool)
        navigation?.add(fragment)
    }
}