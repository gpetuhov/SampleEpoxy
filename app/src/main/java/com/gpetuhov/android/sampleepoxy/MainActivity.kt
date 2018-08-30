package com.gpetuhov.android.sampleepoxy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gpetuhov.android.sampleepoxy.data.Item
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.RecyclerView
import com.gpetuhov.android.sampleepoxy.controller.MainListController
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    val items = mutableListOf<Item>()
    val controller = MainListController(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItems()

        recycler_view.adapter = controller.adapter
        controller.requestModelBuild()

        // This is needed to detect end of list
        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if ((recyclerView?.canScrollVertically(1)) == false) {
                    loadMore()
                }
            }
        })
    }

    private fun addItems() {
        val index = items.size

        for (i in 0..100) {
            items.add(Item("${index + i}", "Data for ${index+i}"))
        }
    }

    private fun loadMore() {
        doAsync {
            Thread.sleep(3000)

            uiThread {
                addItems()
                controller.changeItems(items)
            }
        }
    }
}