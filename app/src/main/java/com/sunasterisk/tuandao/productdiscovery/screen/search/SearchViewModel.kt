package com.sunasterisk.tuandao.productdiscovery.screen.search

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sunasterisk.tuandao.productdiscovery.data.model.Product
import com.sunasterisk.tuandao.productdiscovery.data.repository.SearchRepository
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.NetworkStatus
import com.sunasterisk.tuandao.productdiscovery.screen.base.viewmodel.BaseViewModel
import com.sunasterisk.tuandao.productdiscovery.utils.rx.BaseSchedulerProvider
import com.sunasterisk.tuandao.productdiscovery.utils.rx.SchedulerProvider
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
class SearchViewModel @Inject constructor(application: Application, val repository: SearchRepository) :
    BaseViewModel(application) {
    private val baseSchedulerProvides: BaseSchedulerProvider by lazy { SchedulerProvider.instance }

    private var _products: MutableLiveData<NetworkStatus<List<Product>>> =
        MutableLiveData<NetworkStatus<List<Product>>>().apply { emptyList<Product>() }
    val products: LiveData<NetworkStatus<List<Product>>>
        get() = _products

    fun getSchedulerProvider() = baseSchedulerProvides

    fun searchProducts(keyword: String) {
        val disposable = repository.searchProducts(keyword)
            .subscribeOn(baseSchedulerProvides.io())
            .observeOn(baseSchedulerProvides.ui())
            .subscribe({
                it.result?.data?.let { products ->
                    _products.value = NetworkStatus.success(products)

                }
            }, {
                _products.value = NetworkStatus.failure(it)
            })
        compositeDisposable.addAll(disposable)
    }

    fun clearSearchedResult() {
        val emptyProducts = ArrayList<Product>()
        _products.value = NetworkStatus.success(emptyProducts)
    }

}
