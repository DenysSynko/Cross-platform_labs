package com.example.lr2.data.common

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.serialization.SerializationException

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Failure(val errorMessage: String) : NetworkResult<Nothing>()
}

internal suspend inline fun <reified T> HttpResponse.handleResponse(): NetworkResult<T> {
    return try {
        if (status.value in 200..299) NetworkResult.Success(body<T>())
        else NetworkResult.Failure("Error ${status.value}: ${bodyAsText()}")
    } catch (e: SerializationException) { NetworkResult.Failure("Serialization error") }
}

internal suspend inline fun <reified T> HttpClient.safeRequest(block: suspend HttpClient.() -> HttpResponse): NetworkResult<T> {
    return try { block().handleResponse() } catch (e: Exception) { NetworkResult.Failure(e.message ?: "Network error") }
}