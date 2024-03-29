package com.sunasterisk.tuandao.productdiscovery.data.source.remote

import com.sunasterisk.tuandao.productdiscovery.data.SearchDataSource
import com.sunasterisk.tuandao.productdiscovery.data.model.Product
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.BaseResponse
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.SearchResponse
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.service.Api
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
@Singleton
class SearchRemoteDataSource @Inject constructor(val api: Api) : SearchDataSource.RemoteDataSource {

    override fun searchProducts(query: String): Single<BaseResponse<SearchResponse>> {
        return api.searchProducts(query = query)
    }
}
