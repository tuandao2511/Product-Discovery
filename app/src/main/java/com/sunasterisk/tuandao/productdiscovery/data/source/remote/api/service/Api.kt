package com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.service

import com.sunasterisk.tuandao.productdiscovery.data.model.Product
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.BaseResponse
import com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by tuan-dao.
 * dao.tuan.anh@sun-asterisk.com
 */
interface Api {

    @GET("api/search/")
    fun searchProducts(
        @Query("channel") channel: String = "pv_showroom"
        , @Query("q") query: String, @Query("terminal") terminal: String = "CP01")
            : Single<BaseResponse<SearchResponse>>

//    @GET("api/search/")
//    fun searchProducts(
//        @Query("channel") channel: String = "pv_showroom"
//        , @Query("q") query: String, @Query("terminal") terminal: String = "CP01")
//            : Single<String>
}