package com.gpetuhov.android.sampleepoxy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.gpetuhov.android.sampleepoxy.data.Item
import com.gpetuhov.android.sampleepoxy.models.header
import com.gpetuhov.android.sampleepoxy.models.item
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    val items = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..100) {
            items.add(Item("$i", "Data for $i"))
        }

        recycler_view.withModels {
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
        }

        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if ((recyclerView?.canScrollVertically(1)) == false) {
                    toast("End of list")
                }
            }
        })
    }
}

/** Easily add models to an EpoxyRecyclerView, the same way you would in a buildModels method of EpoxyController. */
fun EpoxyRecyclerView.withModels(buildModelsCallback: EpoxyController.() -> Unit) {
    setControllerAndBuildModels(object : EpoxyController() {
        override fun buildModels() {
            buildModelsCallback()
        }
    })
}