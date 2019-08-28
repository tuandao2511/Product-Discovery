package com.sunasterisk.tuandao.productdiscovery.screen.search

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.tuandao.productdiscovery.R
import com.sunasterisk.tuandao.productdiscovery.data.model.Product
import com.sunasterisk.tuandao.productdiscovery.databinding.ItemProductSearchBinding
import com.sunasterisk.tuandao.productdiscovery.screen.base.recyclerview.BaseRecyclerViewAdapter
import com.sunasterisk.tuandao.productdiscovery.screen.base.recyclerview.OnItemClickListener

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
class SearchAdapter(context: Context) : BaseRecyclerViewAdapter<Product, RecyclerView.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemProductSearchBinding>(
            layoutInflater, R.layout.item_product_search, parent, false
        )
        return SearchViewHolder(binding, onItemClickListener = onItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SearchViewHolder).bindViewHolder(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class SearchViewHolder(
        private val binding: ItemProductSearchBinding,
        private val onItemClickListener: OnItemClickListener<Product>?,
        private val itemSearchViewModel: ItemSearchViewModel = ItemSearchViewModel(onItemClickListener)
        ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.viewModel = itemSearchViewModel
        }

        fun bindViewHolder(product: Product) {
            Log.d("SearchAdapter", "product $product")
            itemSearchViewModel.setData(product)
            itemSearchViewModel.position = adapterPosition
            binding.executePendingBindings()
        }
    }
}
