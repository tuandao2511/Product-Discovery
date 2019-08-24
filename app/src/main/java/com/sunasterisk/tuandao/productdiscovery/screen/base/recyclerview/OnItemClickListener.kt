package com.sunasterisk.tuandao.productdiscovery.screen.base.recyclerview

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
interface OnItemClickListener<T> {

    fun onItemClick(item: T, position: Int)
}
