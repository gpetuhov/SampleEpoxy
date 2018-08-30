package com.gpetuhov.android.sampleepoxy.models

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.gpetuhov.android.sampleepoxy.R

@EpoxyModelClass(layout = R.layout.item_view)
abstract class ItemModel  : EpoxyModelWithHolder<ItemHolder>() {

    @EpoxyAttribute lateinit var left: String
    @EpoxyAttribute lateinit var right: String

    override fun bind(holder: ItemHolder) {
        holder.leftView.text = left
        holder.rightView.text = right
    }
}

class ItemHolder : KotlinHolder() {
    val leftView by bind<TextView>(R.id.left)
    val rightView by bind<TextView>(R.id.right)
}