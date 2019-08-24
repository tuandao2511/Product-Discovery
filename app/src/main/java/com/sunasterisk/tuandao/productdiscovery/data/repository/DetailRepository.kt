package com.sunasterisk.tuandao.productdiscovery.data.repository

import com.sunasterisk.tuandao.productdiscovery.data.DetailDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
@Singleton
class DetailRepository @Inject constructor(val remote: DetailDataSource.RemoteDataSource)
    : DetailDataSource.RemoteDataSource {
}