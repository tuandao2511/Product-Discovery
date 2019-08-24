package com.sunasterisk.tuandao.productdiscovery.utils.rx

import androidx.annotation.NonNull
import io.reactivex.Scheduler

/**
 * Created by tuan-dao on 24/08/2019.
 * dao.tuan.anh@sun-asterisk.com
 */
interface BaseSchedulerProvider {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler
}
