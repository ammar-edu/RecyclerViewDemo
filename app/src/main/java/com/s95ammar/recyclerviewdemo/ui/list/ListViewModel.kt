package com.s95ammar.recyclerviewdemo.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.s95ammar.recyclerviewdemo.model.FakeData
import com.s95ammar.recyclerviewdemo.model.Product

class ListViewModel : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()

    val products: LiveData<List<Product>> = _products

    fun onProductsClick() {
        _products.value = FakeData.products
    }

    fun onProductsNewClick() {
        _products.value = FakeData.productsNew
    }

}