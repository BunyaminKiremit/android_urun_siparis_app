package com.example.bunyamin_kiremit_v2.services

import com.example.bunyamin_kiremit_v2.ProductCard
import com.example.bunyamin_kiremit_v2.models.Cart
import com.example.bunyamin_kiremit_v2.models.DumyCart
import com.example.bunyamin_kiremit_v2.models.Product
import com.example.bunyamin_kiremit_v2.models.ProductList
import retrofit2.Call
import retrofit2.http.*

interface DummyService {

    @GET("products")
    fun getFirstTen(@Query("limit") limit:Int) : Call<ProductList>

    @POST("carts")
    fun createCart(@Body cart: Cart): Call<Cart>

    @GET("carts/{userId}")
    fun getCartItems(@Path("userId") userId: Int): Call<List<Product>>

    @GET("carts/1")
    fun getCart(): Call<DumyCart>

}