package com.example.bunyamin_kiremit_v2.models

import com.google.gson.annotations.SerializedName

data class ProductInCart(
    val id: Int,
    val title: String,
    val price: Int,
    val quantity: Int,
    val total: Int,
    val discountPercentage: Double,
    val discountedPrice: Int
)
{
    override fun toString(): String {
        return title
    }
}