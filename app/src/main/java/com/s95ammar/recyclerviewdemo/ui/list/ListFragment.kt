package com.s95ammar.recyclerviewdemo.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.s95ammar.recyclerviewdemo.R
import com.s95ammar.recyclerviewdemo.model.FakeData
import com.s95ammar.recyclerviewdemo.ui.list.adapter.ProductsAdapter

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.products_recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val productsAdapter = ProductsAdapter()

        // just for demo purposes (the list should be received from the viewModel!)
        productsAdapter.list = FakeData.products

        recyclerView.adapter = productsAdapter
    }
}