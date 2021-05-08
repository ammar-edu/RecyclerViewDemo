package com.s95ammar.recyclerviewdemo.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.s95ammar.recyclerviewdemo.R
import com.s95ammar.recyclerviewdemo.model.Product

class ProductsAdapter(
    private val clickListener: (Product) -> Unit
) : ListAdapter<Product, ProductsAdapter.ProductViewHolder>(ProductDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position)?.let { product ->
            holder.bind(product)
        }
    }

    class ProductViewHolder(
        itemView: View,
        private val clickListener: (Product) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(product: Product) {

            itemView.setOnClickListener {
                clickListener(product)
            }

            val nameTextView = itemView.findViewById<MaterialTextView>(R.id.name_text_view)
            val sellerTextView = itemView.findViewById<MaterialTextView>(R.id.seller_text_view)
            val priceTextView = itemView.findViewById<MaterialTextView>(R.id.price_text_view)

            nameTextView.text = product.name
            sellerTextView.text = product.seller
            priceTextView.text = product.price.toString()
        }
    }

    class ProductDiffUtil : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}
