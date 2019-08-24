package com.sunasterisk.tuandao.productdiscovery.screen.search

import android.os.Bundle
import com.sunasterisk.tuandao.productdiscovery.databinding.ActivitySearchBinding
import com.sunasterisk.tuandao.productdiscovery.screen.base.activity.BaseActivityDataBinding
import androidx.databinding.DataBindingUtil.setContentView
import com.sunasterisk.tuandao.productdiscovery.R
import com.sunasterisk.tuandao.productdiscovery.data.repository.DetailRepository
import com.sunasterisk.tuandao.productdiscovery.databinding.ActivitySearchBinding
import com.sunasterisk.tuandao.productdiscovery.screen.base.activity.BaseActivityDataBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SearchActivity : BaseActivityDataBinding<ActivitySearchBinding, SearchViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }

    override fun retrieveViewOrRestoreState(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutRes(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
