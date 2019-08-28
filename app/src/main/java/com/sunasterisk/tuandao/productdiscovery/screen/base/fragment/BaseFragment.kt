package com.sunasterisk.tuandao.productdiscovery.screen.base.fragment

import android.os.Bundle
import dagger.android.support.DaggerFragment

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
abstract class BaseFragment : DaggerFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retrieveViewOrRestoreState()
    }

    abstract fun retrieveViewOrRestoreState()
}
