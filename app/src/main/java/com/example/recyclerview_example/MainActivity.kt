package com.example.recyclerview_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateDummyList(500)
        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<ExampleItem>{
        val list = ArrayList<ExampleItem>()

        for (i in 0 until size){
            val drawable = when(i%3){
                0 -> R.drawable.ic_baseline_bluetooth
                1 -> R.drawable.ic_baseline_cast_connected
                else -> R.drawable.ic_baseline_fiber_pin
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return  list
    }
}