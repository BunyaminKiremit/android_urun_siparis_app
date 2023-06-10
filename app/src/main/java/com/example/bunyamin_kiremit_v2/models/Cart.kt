package com.example.bunyamin_kiremit_v2.models

import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("products")
    val products: List<ProductInCart>
)
