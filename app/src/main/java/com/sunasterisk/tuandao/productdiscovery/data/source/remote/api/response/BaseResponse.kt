package com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
data class BaseResponse<T> (
    @SerializedName("result")
    val result: T? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("error")
    val error: String? = null
)
