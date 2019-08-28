package com.sunasterisk.tuandao.productdiscovery.utils.binding

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sunasterisk.tuandao.productdiscovery.R
import com.sunasterisk.tuandao.productdiscovery.data.model.Image
import com.sunasterisk.tuandao.productdiscovery.data.model.Price
import com.sunasterisk.tuandao.productdiscovery.utils.StringUtils

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
object BindingUtils {
    @JvmStatic
    @BindingAdapter("bind:ImageUrl")
    fun setImageUrl(imageView: ImageView, images: List<Image>?) {
        Log.d("setImageUrl","list $images")
        if (images.isNullOrEmpty()) {
            Glide.with(imageView.context)
                .load(R.drawable.image_error)
                .into(imageView)
        } else {
            Glide.with(imageView.context)
                .load(Uri.parse(images[0].url))
                .apply(RequestOptions().error(R.drawable.image_error))
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("bind:TextPrice")
    fun setTextPrice(textView: TextView, price: Price) {
        if (price.supplierSalePrice!=null) {
            val text = "${StringUtils.priceToString(price.supplierSalePrice)} đ"
            textView.text = text
        } else {
            textView.setText(R.string.message_text_price)
        }
    }
}