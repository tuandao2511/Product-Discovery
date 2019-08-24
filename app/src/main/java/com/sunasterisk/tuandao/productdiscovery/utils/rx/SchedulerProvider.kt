package com.sunasterisk.tuandao.productdiscovery.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
class SchedulerProvider private constructor() : BaseSchedulerProvider {

    companion object {
        val instance: BaseSchedulerProvider by lazy { SchedulerProvider() }
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
