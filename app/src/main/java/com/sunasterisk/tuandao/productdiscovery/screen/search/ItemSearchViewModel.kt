package com.sunasterisk.tuandao.productdiscovery.screen.search

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sunasterisk.tuandao.productdiscovery.BR
import com.sunasterisk.tuandao.productdiscovery.data.model.Product
import com.sunasterisk.tuandao.productdiscovery.screen.base.recyclerview.OnItemClickListener
import com.sunasterisk.tuandao.productdiscovery.utils.define.notNull

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
class ItemSearchViewModel(
    val itemClickListener: OnItemClickListener<Product>? = null,
    var position: Int = 0,
    @Bindable var products: Product? = null
) : BaseObservable() {

    fun setData(products: Product?) {
        products.notNull {
            this.products = it
            notifyPropertyChanged(BR.products)
        }
    }

    fun onProductClick() {
        itemClickListener.notNull { listener ->
            listener.onItemClick(products!!, position)
        }
    }
}
