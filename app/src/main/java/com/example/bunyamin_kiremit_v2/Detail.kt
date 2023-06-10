package com.example.bunyamin_kiremit_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.bunyamin_kiremit_v2.models.Cart
import com.example.bunyamin_kiremit_v2.models.Product
import com.example.bunyamin_kiremit_v2.models.ProductInCart
import com.example.bunyamin_kiremit_v2.services.DummyService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Detail : AppCompatActivity() {

    lateinit var imageView:ImageView
    lateinit var txtTitle:TextView
    lateinit var txtDescription:TextView
    lateinit var txtPrice:TextView
    lateinit var txtRating:TextView
    lateinit var btnAdd:Button
    lateinit var products : List<Product>

    lateinit var dummyService: DummyService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imageView=findViewById(R.id.imageView)
        txtTitle=findViewById(R.id.txtTitle)
        txtDescription=findViewById(R.id.txtDescription)
        txtPrice=findViewById(R.id.txtPrice)
        txtRating=findViewById(R.id.txtRating)
        btnAdd=findViewById(R.id.btnAdd)


        Glide.with(this)
            .load(MainActivity.detailProduct.thumbnail)
            .override(300, 300)
            .centerCrop()
            .into(imageView)

        txtTitle.text = MainActivity.detailProduct.title
        txtDescription.text = MainActivity.detailProduct.description
        txtPrice.text = "${MainActivity.detailProduct.price} TL"
        txtRating.text = "${MainActivity.detailProduct.rating} / 5"

        val product = ProductInCart(1, "Ürün 1", 10, 2, 20, 0.1, 18)

        btnAdd.setOnClickListener(){
            addToCart(product)
            var intent = Intent(this, ProductCard::class.java)
            startActivity(intent)

        }

    }
    private fun addToCart(product: ProductInCart) {
        val userId = 1
        val products = listOf(product)
        val cart = Cart(userId, products)
        val gson = Gson()
        val cartJson = gson.toJson(cart)
    }

}