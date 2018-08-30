package com.gpetuhov.android.sampleepoxy.models

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.gpetuhov.android.sampleepoxy.R

@EpoxyModelClass(layout = R.layout.header_view)
abstract class HeaderModel : EpoxyModelWithHolder<Holder>() {

    @EpoxyAttribute lateinit var title: String

    override fun bind(holder: Holder) {
        holder.titleView.text = title
    }
}

class Holder : KotlinHolder() {
    val titleView by bind<TextView>(R.id.title)
}