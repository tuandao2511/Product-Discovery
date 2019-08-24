package com.sunasterisk.tuandao.productdiscovery.screen.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponents(savedInstanceState)
    }

    abstract fun initComponents(savedInstanceState: Bundle?)

    fun getSupportActionbar(title: Int) {
        supportActionBar?.title = getString(title)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
