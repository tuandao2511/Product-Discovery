package com.sunasterisk.tuandao.productdiscovery.data.source.remote.api.response

/**
 * Created by tuan-dao.
 * Contact: dao.tuan.anh@sun-asterisk.com
 */
sealed class NetworkStatus<T> {
    data class Progress<T>(var loading: Boolean) : NetworkStatus<T>()
    data class Success<T>(var data: T) : NetworkStatus<T>()
    data class Failure<T>(val e: Throwable) : NetworkStatus<T>()

    companion object {
        fun <T> loading(isLoading: Boolean): NetworkStatus<T> = Progress(isLoading)
        fun <T> success(data: T): NetworkStatus<T> = Success(data)
        fun <T> failure(e: Throwable): NetworkStatus<T> = Failure(e)
    }
}
