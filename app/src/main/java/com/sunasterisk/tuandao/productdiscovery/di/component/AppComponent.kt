package com.sunasterisk.tuandao.productdiscovery.di.component

import android.app.Application
import com.sunasterisk.tuandao.productdiscovery.PDApp
import com.sunasterisk.tuandao.productdiscovery.data.repository.DetailRepository
import com.sunasterisk.tuandao.productdiscovery.data.repository.SearchRepository
import com.sunasterisk.tuandao.productdiscovery.di.module.ActivityBuildersModule
import com.sunasterisk.tuandao.productdiscovery.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class,
        ActivityBuildersModule::class])
interface AppComponent : AndroidInjector<PDApp> {

    fun getSearchRepository(): SearchRepository

    fun getDetailRepository(): DetailRepository

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
