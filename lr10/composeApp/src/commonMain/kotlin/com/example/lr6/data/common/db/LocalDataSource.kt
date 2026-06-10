package com.example.lr6.data.common.db

import com.example.lr6.Task

interface LocalDataSource {
    fun insertTask(description: String)
    fun getAllTasks(): List<Task>
    fun markTaskCompleted(id: Long)
    fun markTaskPending(id: Long)
    fun deleteTask(id: Long)
}