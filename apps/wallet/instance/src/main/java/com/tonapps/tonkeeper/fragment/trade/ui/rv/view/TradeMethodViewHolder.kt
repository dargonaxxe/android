package com.tonapps.tonkeeper.fragment.trade.ui.rv.view

import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.tonapps.tonkeeper.fragment.trade.ui.rv.model.TradeMethodListItem
import com.tonapps.tonkeeperx.R
import com.tonapps.uikit.list.BaseListHolder
import uikit.extensions.setThrottleClickListener

class TradeMethodViewHolder(
    parent: ViewGroup,
    val onItemClicked: (TradeMethodListItem) -> Unit
) : BaseListHolder<TradeMethodListItem>(parent, R.layout.view_trade_method) {

    private val radioButton = findViewById<RadioButton>(R.id.view_trade_method_radio_button)
    private val titleTextView = findViewById<TextView>(R.id.view_trade_method_title_view)
    private val draweeView = findViewById<SimpleDraweeView>(R.id.view_trade_method_drawee_view)

    override fun onBind(item: TradeMethodListItem) {
        radioButton.isChecked = item.isChecked
        titleTextView.text = item.title
        draweeView.setImageURI(item.iconUrl)
        itemView.setThrottleClickListener { onItemClicked(item) }
    }
}