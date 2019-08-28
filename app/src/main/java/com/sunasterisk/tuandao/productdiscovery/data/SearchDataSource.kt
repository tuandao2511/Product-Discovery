package com.sunasterisk.tuandao.productdiscovery.data

import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.BaseResponse
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.SearchResponse
import io.reactivex.Single

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
interface SearchDataSource {

    interface RemoteDataSource {
        fun searchProducts(query: String) : Single<BaseResponse<SearchResponse>>
    }

}