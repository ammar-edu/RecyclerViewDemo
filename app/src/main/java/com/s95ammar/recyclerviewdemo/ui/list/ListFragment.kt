package com.s95ammar.recyclerviewdemo.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.s95ammar.recyclerviewdemo.R
import com.s95ammar.recyclerviewdemo.model.Product
import com.s95ammar.recyclerviewdemo.ui.list.adapter.ProductsAdapter

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private val viewModel: ListViewModel by viewModels()
    private val productsAdapter = ProductsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.products_recyclerview)
        val productsButton = view.findViewById<Button>(R.id.products_button)
        val productsNewButton = view.findViewById<Button>(R.id.products_new_button)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = productsAdapter

        productsButton.setOnClickListener { viewModel.onProductsClick() }
        productsNewButton.setOnClickListener { viewModel.onProductsNewClick() }

        viewModel.products.observe(viewLifecycleOwner) { products ->
            setProducts(products)
        }
    }

    private fun setProducts(products: List<Product>) {
        productsAdapter.submitList(products) {
            val recyclerView = view?.findViewById<RecyclerView>(R.id.products_recyclerview)
            recyclerView?.layoutManager?.scrollToPosition(0)
        }
    }
}