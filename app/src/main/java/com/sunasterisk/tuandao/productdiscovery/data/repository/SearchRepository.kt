package com.sunasterisk.tuandao.productdiscovery.data.repository

import com.sunasterisk.tuandao.productdiscovery.data.SearchDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
@Singleton
class SearchRepository @Inject constructor(val remote: SearchDataSource.RemoteDataSource)
    : SearchDataSource.RemoteDataSource {
}