package com.tonapps.tonkeeper.extensions

import com.tonapps.icu.CurrencyFormatter
import com.tonapps.wallet.data.rates.entity.RatesEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull

fun formattedRate(
    rateFlow: Flow<RatesEntity>,
    amountFlow: Flow<Float>,
    token: String,
    formatter: (currencyCode: String, amount: Float) -> CharSequence = CurrencyFormatter::format
): Flow<CharSequence> = combine(rateFlow, amountFlow) { rates, amount ->
    val rate = rates.rate(token) ?: return@combine null
    val totalAmount = rate.value * amount
    return@combine formatter(rates.currency.code, totalAmount)
}.filterNotNull()