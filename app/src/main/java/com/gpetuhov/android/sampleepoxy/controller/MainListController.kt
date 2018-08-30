package com.gpetuhov.android.sampleepoxy.controller

import com.airbnb.epoxy.EpoxyController
import com.gpetuhov.android.sampleepoxy.data.Item
import com.gpetuhov.android.sampleepoxy.models.header
import com.gpetuhov.android.sampleepoxy.models.item
import com.gpetuhov.android.sampleepoxy.models.loader

class MainListController(private var items: MutableList<Item>) : EpoxyController() {

    override fun buildModels() {
        header {
            id("header")
            title("This is the title")
        }

        items.forEach {
            item {
                id("item ${it.left}")
                left(it.left)
                right(it.right)
            }
        }

        loader {
            id("loader")
        }
    }

    fun changeItems(items: MutableList<Item>) {
        this.items = items
        requestModelBuild()
    }
}