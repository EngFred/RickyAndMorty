package com.engineerfred.kotlin.core.common

sealed class ApiResponse<out T>  {
    data class Success<T>( val data: T ) : ApiResponse<T>()
    data class Failure( val exception: Exception ) : ApiResponse<Nothing>()
    data object Loading: ApiResponse<Nothing>()
}