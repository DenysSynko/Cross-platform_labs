package com.example.lr2.data.api

import com.example.lr2.data.common.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiService(private val client: HttpClient) {
    suspend fun getPosts() = client.safeRequest<String> { get("https://dummyjson.com/posts") }

    suspend fun addPost(postData: Any) = client.safeRequest<String> {
        post("https://dummyjson.com/posts/add") {
            contentType(ContentType.Application.Json)
            setBody(postData)
        }
    }

    suspend fun updatePost() = client.safeRequest<String> { put("https://dummyjson.com/posts/1") }
    suspend fun deletePost() = client.safeRequest<String> { delete("https://dummyjson.com/posts/1") }
}