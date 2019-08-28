package com.sunasterisk.tuandao.productdiscovery.screen.search

import androidx.lifecycle.ViewModelProviders
import com.sunasterisk.tuandao.productdiscovery.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import java.lang.annotation.Documented
import javax.inject.Scope

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
@Module
class SearchModule {
    @SearchActivityScope
    @Provides
    fun provideViewModel(searchActivity: SearchActivity, viewModelFactory: ViewModelFactory) =
        ViewModelProviders.of(searchActivity, viewModelFactory).get(SearchViewModel::class.java)
}

@Scope
@Documented
@Retention(AnnotationRetention.RUNTIME)
annotation class SearchActivityScope
