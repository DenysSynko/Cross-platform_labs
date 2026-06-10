package com.example.lr2.domain.repository

import com.example.lr2.data.api.ApiService

class Repository(private val api: ApiService) {
    suspend fun getPosts() = api.getPosts()
    suspend fun addPost(postData: Any) = api.addPost(postData)
    suspend fun updatePost() = api.updatePost()
    suspend fun deletePost() = api.deletePost()
}