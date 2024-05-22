package com.tonapps.tonkeeper.fragment.swap.root

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonapps.icu.CurrencyFormatter
import com.tonapps.tonkeeper.core.emit
import com.tonapps.tonkeeper.core.observeFlow
import com.tonapps.tonkeeper.fragment.swap.domain.DexAssetsRepository
import com.tonapps.tonkeeper.fragment.swap.domain.GetDefaultSwapSettingsCase
import com.tonapps.tonkeeper.fragment.swap.domain.model.DexAsset
import com.tonapps.tonkeeper.fragment.swap.domain.model.SwapSimulation
import com.tonapps.tonkeeper.fragment.swap.pick_asset.PickAssetResult
import com.tonapps.tonkeeper.fragment.swap.pick_asset.PickAssetType
import com.tonapps.tonkeeper.fragment.swap.settings.SwapSettingsResult
import com.tonapps.wallet.data.account.WalletRepository
import com.tonapps.wallet.data.core.WalletCurrency
import com.tonapps.wallet.data.rates.RatesRepository
import com.tonapps.wallet.data.settings.SettingsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.RoundingMode

@OptIn(ExperimentalCoroutinesApi::class)
class SwapViewModel(
    private val repository: DexAssetsRepository,
    walletManager: WalletRepository,
    getDefaultSwapSettingsCase: GetDefaultSwapSettingsCase,
    settingsRepository: SettingsRepository,
    private val ratesRepository: RatesRepository
) : ViewModel() {

    private val swapSettings = MutableStateFlow(getDefaultSwapSettingsCase.execute())
    private val _pickedSendAsset = MutableStateFlow<DexAsset?>(null)
    private val _pickedReceiveAsset = MutableStateFlow<DexAsset?>(null)
    private val _events = MutableSharedFlow<SwapEvent>()
    private val activeWallet = walletManager.activeWalletFlow
        .shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)
    private val pairFlow = combine(activeWallet, _pickedSendAsset) { a, b -> a to b }
        .shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)
    private val sendAmount = MutableStateFlow(BigDecimal.ZERO)
    private val currency = settingsRepository.currencyFlow

    val isLoading = repository.isLoading
    val events: Flow<SwapEvent>
        get() = _events
    val pickedSendAsset: Flow<DexAsset?>
        get() = _pickedSendAsset
    val pickedReceiveAsset: Flow<DexAsset?>
        get() = _pickedReceiveAsset
    val receiveAmount = combine(
        sendAmount,
        pickedSendAsset,
        pickedReceiveAsset
    ) { amount, sendAsset, receiveAsset  ->
        when {
            sendAsset == null -> null
            receiveAsset == null -> null
            else -> {
                val amount = amount * sendAsset.dexUsdPrice / receiveAsset.dexUsdPrice
                receiveAsset to amount
            }
        }
    }.shareIn(viewModelScope, SharingStarted.Lazily, replay = 1)
    val simulation = combine(
        pickedSendAsset,
        pickedReceiveAsset,
        sendAmount,
        swapSettings
    ) { sendAsset, receiveAsset, amount, settings ->
        sendAsset ?: return@combine null
        receiveAsset ?: return@combine null
        if (amount == BigDecimal.ZERO) return@combine null
        val a = sendAsset to receiveAsset
        val b = amount to settings
        a to b
    }
        .flatMapLatest { c ->
            val (a, b) = c ?: return@flatMapLatest flowOf(null)
            val (sendAsset, receiveAsset) = a
            val (amount, settings) = b
            repository.emulateSwap(sendAsset, receiveAsset, amount, settings.slippagePercent)
        }
        .shareIn(viewModelScope, started = SharingStarted.Lazily, replay = 1)


    init {
        observeFlow(isLoading) { isLoading ->
            if (isLoading) return@observeFlow
            _pickedSendAsset.emit(repository.getDefaultAsset())
        }
    }

    fun onSettingsClicked() {
        val settings = swapSettings.value
        val event = SwapEvent.NavigateToSwapSettings(settings)
        emit(_events, event)
    }

    fun onCrossClicked() {
        emit(_events, SwapEvent.NavigateBack)
    }

    fun onSendTokenClicked() {
        val event = SwapEvent.NavigateToPickAsset(PickAssetType.SEND)
        emit(_events, event)
    }

    fun onReceiveTokenClicked() {
        val event = SwapEvent.NavigateToPickAsset(PickAssetType.RECEIVE)
        emit(_events, event)
    }

    fun onSwapTokensClicked() = viewModelScope.launch {
        val toSend = _pickedSendAsset.value
        val toSendAmount = sendAmount.value
        val toReceiveAmount = receiveAmount.first()
        _pickedSendAsset.value = _pickedReceiveAsset.value
        _pickedReceiveAsset.value = toSend
        when {
            toSendAmount == BigDecimal.ZERO -> Unit
            toReceiveAmount == null -> Unit
            else -> {
                sendAmount.value = toReceiveAmount.second
                ignoreNextUpdate = true
                _events.emit(SwapEvent.FillInput(toReceiveAmount.second.setScale(2, RoundingMode.FLOOR).toPlainString()))
            }
        }
    }

    private var ignoreNextUpdate = false
    fun onSendAmountChanged(amount: BigDecimal) {
        if (sendAmount.value == amount) return
        if (ignoreNextUpdate) {
            ignoreNextUpdate = false
            return
        }
        sendAmount.value = amount
    }

    fun onAssetPicked(result: PickAssetResult) {
        when (result.type) {
            PickAssetType.SEND -> {
                _pickedSendAsset.value = result.asset
            }
            PickAssetType.RECEIVE -> {
                _pickedReceiveAsset.value = result.asset
            }
        }
    }

    fun onSettingsUpdated(result: SwapSettingsResult) {
        swapSettings.value = result.settings
    }

    fun onConfirmClicked() = viewModelScope.launch {
        val sendToken = _pickedSendAsset.value ?: return@launch
        val receiveToken = _pickedReceiveAsset.value ?: return@launch
        val amount = sendAmount.value
        val settings = swapSettings.value
        val simulation = simulation.first() as? SwapSimulation.Result ?: return@launch
        val currency = currency.first()
        val event = SwapEvent.NavigateToConfirm(
            sendToken,
            receiveToken,
            settings,
            amount,
            simulation,
            currency = currency,
            ratesCurrency = ratesRepository.cache(currency, listOf("TON")),
            ratesUsd = ratesRepository.cache(WalletCurrency.DEFAULT, listOf("TON"))
        )
        _events.emit(event)
    }

    fun onMaxClicked() = viewModelScope.launch {
        val balance = _pickedSendAsset.value?.balance ?: return@launch
        sendAmount.value = balance
        ignoreNextUpdate = true
        _events.emit(
            SwapEvent.FillInput(
                CurrencyFormatter.format(balance, 2)
            )
        )
    }
}