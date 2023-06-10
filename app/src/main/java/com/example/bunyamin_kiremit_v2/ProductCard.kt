package com.example.bunyamin_kiremit_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.bunyamin_kiremit_v2.adapters.CartCustomAdapter
import com.example.bunyamin_kiremit_v2.configs.ApiClient
import com.example.bunyamin_kiremit_v2.models.DumyCart
import com.example.bunyamin_kiremit_v2.models.ProductInCart
import com.example.bunyamin_kiremit_v2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductCard : AppCompatActivity() {

    private lateinit var dummyService: DummyService
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_card)

        listView = findViewById(R.id.listCart)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        dummyService.getCart().enqueue(object : Callback<DumyCart> {
            override fun onResponse(call: Call<DumyCart>, response: Response<DumyCart>) {
                val data = response.body()
                val list = data!!.products
                val customAdapter = CartCustomAdapter(this@ProductCard, list!!)
                listView.adapter = customAdapter
            }

            override fun onFailure(call: Call<DumyCart>, t: Throwable) {
                Toast.makeText(this@ProductCard, "Hata Oluştu!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

