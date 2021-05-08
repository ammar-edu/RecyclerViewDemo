package com.s95ammar.recyclerviewdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.s95ammar.recyclerviewdemo.Constants
import com.s95ammar.recyclerviewdemo.R
import com.s95ammar.recyclerviewdemo.model.Product
import com.s95ammar.recyclerviewdemo.ui.list.ProductListFragment

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(Constants.REQUEST_KEY_RESULT_PRODUCT_BUNDLE) { _, bundle ->
            val product = bundle.getParcelable<Product>(Constants.KEY_PRODUCT)
            view.findViewById<TextView>(R.id.product_text_view).text = product.toString()
        }

        view.findViewById<Button>(R.id.choose_product_button).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, ProductListFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
}