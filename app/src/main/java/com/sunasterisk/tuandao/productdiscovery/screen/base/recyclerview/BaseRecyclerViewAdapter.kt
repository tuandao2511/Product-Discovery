package com.sunasterisk.tuandao.productdiscovery.screen.base.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.tuandao.productdiscovery.utils.define.notNull

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
abstract class BaseRecyclerViewAdapter<T, V : RecyclerView.ViewHolder> constructor(
    protected val context: Context,
    protected var layoutInflater: LayoutInflater = LayoutInflater.from(
        context
    ),
    protected var listData: MutableList<T> = mutableListOf()
) :
    RecyclerView.Adapter<V>() {

    protected var onItemClickListener: OnItemClickListener<T>? = null

    companion object {
        const val DEFAULT_LAST_POSITION = -1
    }

    var lastPosition = DEFAULT_LAST_POSITION

    override fun onViewDetachedFromWindow(holder: V) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun getData(): MutableList<T> {
        return listData
    }

    fun refreshData(data: MutableList<T>) {
        data.notNull {
            Log.d("refreshData"," data $data")
            lastPosition = DEFAULT_LAST_POSITION
            listData.clear()
            listData.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun addData(data: MutableList<T>) {
        data.notNull {
            listData.addAll(it)
            notifyItemRangeChanged(listData.size, it.size)
        }
    }

    fun registerOnItemClickListener(
        onItemClickListener: OnItemClickListener<T>
    ) {
        this.onItemClickListener = onItemClickListener
    }
}
