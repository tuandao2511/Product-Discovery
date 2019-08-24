package com.sunasterisk.tuandao.productdiscovery.utils.define

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */

inline fun <T : Any> T?.notNull(f: (it: T) -> Unit) {
    if (this != null) f(this)
}