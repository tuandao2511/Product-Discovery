package com.sunasterisk.tuandao.productdiscovery.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
data class Price(
    @SerializedName("supplierSalePrice")
    val supplierSalePrice: Double? = null,
    @SerializedName("sellPrice")
    val sellPrice: Double? = null
)
