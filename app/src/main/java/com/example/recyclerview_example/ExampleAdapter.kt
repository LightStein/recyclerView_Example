package com.example.recyclerview_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val exampleList: List<ExampleItem>,
private val listener: OnItemClickListener): RecyclerView.Adapter<ExampleAdapter.ExapleViewHolder>(){

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

    inner class ExapleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val iamgeView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            listener.onItemClick(position)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}