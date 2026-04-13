package com.example.latihan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class ProductAdapter(
    private val products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: MaterialCardView = view as MaterialCardView
        val tvName: TextView = view.findViewById(R.id.tvProductName)
        val tvCategory: TextView = view.findViewById(R.id.tvProductCategory)
        val tvPrice: TextView = view.findViewById(R.id.tvProductPrice)
        val ivImage: ImageView = view.findViewById(R.id.ivProductImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.tvName.text = product.name
        holder.tvCategory.text = product.category
        holder.tvPrice.text = product.getFormattedPrice()

        // Load gambar lokal
        if (product.imageRes != 0) {
            holder.ivImage.setImageResource(product.imageRes)
        }

        // Badge hijau kalau gratis, ungu kalau berbayar
        if (product.price == 0) {
            holder.tvPrice.setBackgroundResource(R.drawable.bg_badge_green)
            holder.tvPrice.setTextColor(
                holder.itemView.context.getColor(R.color.green_text)
            )
        } else {
            holder.tvPrice.setBackgroundResource(R.drawable.bg_badge_purple)
            holder.tvPrice.setTextColor(
                holder.itemView.context.getColor(R.color.purple_primary)
            )
        }
    }

    override fun getItemCount(): Int = products.size
}