package com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response

import com.google.gson.annotations.SerializedName
import com.sunasterisk.tuandao.productdiscovery.data.model.Product

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
data class SearchResponse(
    @SerializedName("products")
    val data: List<Product>? = null
)