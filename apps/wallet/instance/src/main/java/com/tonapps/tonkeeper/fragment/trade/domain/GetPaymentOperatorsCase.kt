package com.tonapps.tonkeeper.fragment.trade.domain

import com.tonapps.tonkeeper.App
import com.tonapps.tonkeeper.fragment.trade.domain.model.PaymentOperator

class GetPaymentOperatorsCase {
    suspend fun execute(
        country: String,
        paymentMethodId: String,
        currencyCode: String
    ): List<PaymentOperator> {
        return App.fiat.getMethods(country)
            .map {
                PaymentOperator(
                    id = it.id,
                    name = it.title,
                    description = it.description,
                    iconUrl = it.iconUrl,
                    url = it.actionButton.url,
                    successUrlPattern = it.successUrlPattern
                )
            }
    }
}