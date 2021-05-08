package com.s95ammar.recyclerviewdemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val seller: String
) : Parcelable
