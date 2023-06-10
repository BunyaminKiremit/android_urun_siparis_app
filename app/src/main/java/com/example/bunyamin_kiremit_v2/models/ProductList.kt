package com.example.bunyamin_kiremit_v2.models

import com.google.gson.annotations.SerializedName

class ProductList {
    @SerializedName("products")
    var plist : List<Product?>? = null
}