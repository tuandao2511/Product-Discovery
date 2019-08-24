package com.sunasterisk.tuandao.productdiscovery

import com.sunasterisk.tuandao.productdiscovery.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
class PDApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()
}