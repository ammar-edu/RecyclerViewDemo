package com.s95ammar.recyclerviewdemo.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.s95ammar.recyclerviewdemo.R
import com.s95ammar.recyclerviewdemo.model.Product

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    var list = emptyList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        list.getOrNull(position)?.let { product ->
            holder.bind(product)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(product: Product) {


            val nameTextView = itemView.findViewById<MaterialTextView>(R.id.name_text_view)
            val sellerTextView = itemView.findViewById<MaterialTextView>(R.id.seller_text_view)
            val priceTextView = itemView.findViewById<MaterialTextView>(R.id.price_text_view)

            nameTextView.text = product.name
            sellerTextView.text = product.seller
            priceTextView.text = product.price.toString()
        }
    }
}
