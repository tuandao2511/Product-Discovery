package com.sunasterisk.tuandao.productdiscovery.data.repository

import com.sunasterisk.tuandao.productdiscovery.data.SearchDataSource
import com.sunasterisk.tuandao.productdiscovery.data.model.Product
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.BaseResponse
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.SearchResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
@Singleton
class SearchRepository @Inject constructor(val remote: SearchDataSource.RemoteDataSource)
    : SearchDataSource.RemoteDataSource {
    override fun searchProducts(query: String): Single<BaseResponse<SearchResponse>> {
        return remote.searchProducts(query)
    }
}
