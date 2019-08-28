package com.sunasterisk.tuandao.productdiscovery.utils

import java.text.DecimalFormat

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
object StringUtils {

    fun priceWithDecimal(price: Double?): String {
        val formatter = DecimalFormat("###,###,###.00")
        return formatter.format(price)
    }

    fun priceWithoutDecimal(price: Double?): String {
        val formatter = DecimalFormat("###,###,###.##")
        return formatter.format(price)
    }

    fun priceToString(price: Double?): String {
        val toShow = priceWithoutDecimal(price)
        return if (toShow.indexOf(".") > 0) {
            priceWithDecimal(price)
        } else {
            priceWithoutDecimal(price)
        }
    }
}
