package com.sunasterisk.tuandao.productdiscovery.screen.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
abstract class BaseDataBindingFragment<ViewBinding : ViewDataBinding, ViewModel : AndroidViewModel> :
    BaseFragment() {

    lateinit var viewDataBinding: ViewBinding
    lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil
            .inflate(inflater, getLayoutId(), container, false)
        viewDataBinding.setLifecycleOwner(this)
        initOnCreateView()
        retainInstance = true
        return viewDataBinding.root
    }

    abstract fun initOnCreateView()

    abstract fun getLayoutId(): Int
}
