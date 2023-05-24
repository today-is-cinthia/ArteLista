package com.example.login.data

interface ICallback<T> {

    fun onSuccess(result: T?)
    fun onFailed(exception: Exception)
}


