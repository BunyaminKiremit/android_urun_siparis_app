package com.example.bunyamin_kiremit_v2.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.bunyamin_kiremit_v2.R
import com.example.bunyamin_kiremit_v2.models.Product

class ProductsAdapter(private val context : Activity, private val list : List<Product>) : ArrayAdapter<Product>(context, R.layout.product_list, list){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = context.layoutInflater.inflate(R.layout.product_list, null, true)

        val title = view.findViewById<TextView>(R.id.txtTitle)
        val thumbnail = view.findViewById<ImageView>(R.id.imgThumbnail)
        val price = view.findViewById<TextView>(R.id.txtPrice)

        val product = list.get(position)

        title.text = product.title
        price.text = product.price.toString() + " TL"
        Glide.with(view).load(product.thumbnail).into(thumbnail)

        return view
    }

}
