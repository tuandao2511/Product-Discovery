package com.sunasterisk.tuandao.productdiscovery.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
data class Product(
    @SerializedName("displayName")
    val displayName: String? = null,
    @SerializedName("price")
    val price: Price? = null,
    @SerializedName("images")
    val images: List<Image>? = null,
    @SerializedName("name")
    val name: String? = null
)
