package com.sunasterisk.tuandao.productdiscovery.screen.search

import android.os.Bundle
import com.sunasterisk.tuandao.productdiscovery.R
import com.sunasterisk.tuandao.productdiscovery.data.repository.DetailRepository
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SearchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var repository: DetailRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}
