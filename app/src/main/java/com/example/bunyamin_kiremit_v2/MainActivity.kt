package com.example.bunyamin_kiremit_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.bunyamin_kiremit_v2.adapters.ProductsAdapter
import com.example.bunyamin_kiremit_v2.configs.ApiClient
import com.example.bunyamin_kiremit_v2.models.Product
import com.example.bunyamin_kiremit_v2.models.ProductList
import com.example.bunyamin_kiremit_v2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var  listProducts:ListView
    lateinit var  btnGoCard:Button

    lateinit var dummyService: DummyService
    lateinit var products : List<Product>

    var policy : StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()

    companion object{
        lateinit var detailProduct : Product
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listProducts = findViewById(R.id.listProducts)
        btnGoCard=findViewById(R.id.btnGoCard)

        StrictMode.setThreadPolicy(policy)
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        products = listOf()

        var productsAdapter = ProductsAdapter(this@MainActivity, products)
        listProducts.adapter = productsAdapter

        dummyService.getFirstTen(30).enqueue(object : Callback<ProductList> {
            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>){
                if(response.body() != null){
                    products = (response.body()!!.plist as List<Product>?)!!
                    var productsAdapter = ProductsAdapter(this@MainActivity, products)
                    listProducts.adapter = productsAdapter
                    //productsAdapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                Log.e("error : " , t.toString())
                Toast.makeText(this@MainActivity, "Failed to fetch products", Toast.LENGTH_LONG).show()

            }
        })

        listProducts.setOnItemClickListener { parent, view, position, id ->
            detailProduct = products.get(id.toInt())
            var intent = Intent(this, Detail::class.java)
            startActivity(intent)
        }

        btnGoCard.setOnClickListener(){
            var intent = Intent(this, ProductCard::class.java)
            startActivity(intent)
        }



    }
}