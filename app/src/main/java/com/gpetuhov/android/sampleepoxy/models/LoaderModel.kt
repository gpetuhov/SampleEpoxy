package com.gpetuhov.android.sampleepoxy.models

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.gpetuhov.android.sampleepoxy.R

@EpoxyModelClass(layout = R.layout.loader_view)
abstract class LoaderModel  : EpoxyModelWithHolder<LoaderHolder>()

class LoaderHolder : KotlinHolder()