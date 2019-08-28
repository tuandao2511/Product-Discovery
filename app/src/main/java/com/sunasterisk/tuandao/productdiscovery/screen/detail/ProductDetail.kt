package com.sunasterisk.tuandao.productdiscovery.screen.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunasterisk.tuandao.productdiscovery.R

class ProductDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, ProductDetail::class.java)
    }
}
