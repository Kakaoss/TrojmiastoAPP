package com.example.trjmiastoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImageView: ImageView = view.findViewById(R.id.item_image_view)
        val itemTextView: TextView = view.findViewById(R.id.item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemImageView.setImageResource(item.imageId)
        holder.itemTextView.text = item.title
    }

    override fun getItemCount() = items.size
}