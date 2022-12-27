package com.example.common.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart


sealed interface Result<out T> {
    object Loading : Result<Nothing>
    class Success<T>(data: T) : Result<T>
    class Error(throwable: Throwable? = null) : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            Result.Success(it)
        }
        .onStart {
            emit(Result.Loading)
        }
        .catch { e ->
            emit(Result.Error(e))
        }
}