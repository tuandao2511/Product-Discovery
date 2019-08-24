package com.sunasterisk.tuandao.productdiscovery.screen.base.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
abstract class BaseFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retrieveViewOrRestoreState()
    }

    abstract fun retrieveViewOrRestoreState()
}
