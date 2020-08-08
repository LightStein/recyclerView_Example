package com.example.recyclerview_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val exampleList: List<ExampleItem>): RecyclerView.Adapter<ExampleAdapter.ExapleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExapleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)

        return ExapleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExapleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.iamgeView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
    }

    override fun getItemCount() = exampleList.size

    class ExapleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val iamgeView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}