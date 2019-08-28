package com.sunasterisk.tuandao.productdiscovery.di.module

import com.sunasterisk.tuandao.productdiscovery.screen.search.SearchActivity
import com.sunasterisk.tuandao.productdiscovery.screen.search.SearchActivityScope
import com.sunasterisk.tuandao.productdiscovery.screen.search.SearchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
@Module
abstract class ActivityBuildersModule {

    @SearchActivityScope
    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun contributeSearchActivity(): SearchActivity
}
