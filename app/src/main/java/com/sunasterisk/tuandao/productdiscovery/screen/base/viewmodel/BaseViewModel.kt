package com.sunasterisk.tuandao.productdiscovery.screen.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
open class BaseViewModel(application: Application) :
    AndroidViewModel(application),
    LifecycleObserver {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
