package com.sunasterisk.tuandao.productdiscovery.screen.search

import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunasterisk.tuandao.productdiscovery.data.model.Product
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.NetworkStatus
import com.sunasterisk.tuandao.productdiscovery.databinding.ActivitySearchBinding
import com.sunasterisk.tuandao.productdiscovery.screen.base.activity.BaseActivityDataBinding
import com.sunasterisk.tuandao.productdiscovery.screen.base.recyclerview.OnItemClickListener
import com.sunasterisk.tuandao.productdiscovery.screen.detail.ProductDetail
import com.sunasterisk.tuandao.productdiscovery.utils.Constant.SEARCH_DEBOUNCE_TIME
import com.sunasterisk.tuandao.productdiscovery.utils.showErrorMessage
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.layout_search_box.view.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchActivity : BaseActivityDataBinding<ActivitySearchBinding>(), OnItemClickListener<Product>{

    @Inject
    lateinit var viewModel: SearchViewModel
    private lateinit var adapter: SearchAdapter
    private var lastQuery: String = ""

    override fun getLayoutRes() = com.sunasterisk.tuandao.productdiscovery.R.layout.activity_search

    override fun retrieveViewOrRestoreState(savedInstanceState: Bundle?) {
        adapter = SearchAdapter(this)
        viewDataBinding.recyclerSearchProduct.layoutManager = LinearLayoutManager(this)
        viewDataBinding.recyclerSearchProduct.adapter = adapter
        adapter.registerOnItemClickListener(this)
        setupActionBar()
    }

    override fun onItemClick(item: Product, position: Int) {
        startActivity(ProductDetail.getIntent(this))
    }

    private fun setupActionBar() {
        val actionBar = supportActionBar
        actionBar?.hide()
        setupSearchView()
        registerData()
    }

    private fun registerData() {
        viewModel.products.observe(this, Observer {
            when(it) {
                is NetworkStatus.Success -> {
                    it?.data?.let {products ->
                        adapter.refreshData(products as MutableList<Product>)
                    }
                }
                is NetworkStatus.Failure -> {
                    showErrorMessage(it.e.message.toString())
                }
            }
        })
    }

    private fun setupSearchView() {
        RxSearchObservable.fromView(viewDataBinding.layoutSearchBox.searchProduct)
            .debounce(SEARCH_DEBOUNCE_TIME, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .subscribeOn(viewModel.getSchedulerProvider().io())
            .observeOn(viewModel.getSchedulerProvider().ui())
            .subscribe {
                if (!it.isNullOrEmpty()) {
                    lastQuery = it.trim()
                    viewModel.searchProducts(lastQuery)
                    return@subscribe
                }
                lastQuery = ""
                viewModel.clearSearchedResult()
            }
    }

    object RxSearchObservable {
        fun fromView(searchView: SearchView): Observable<String> {
            val subject: PublishSubject<String> = PublishSubject.create()

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    subject.onComplete()
                    return true
                }

                override fun onQueryTextChange(text: String?): Boolean {
                    subject.onNext(text!!)
                    return true
                }

            })
            return subject
        }
    }
}
