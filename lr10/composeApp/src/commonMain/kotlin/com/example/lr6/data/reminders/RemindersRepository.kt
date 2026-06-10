package com.example.lr6.data.reminders

import com.example.lr6.data.common.db.LocalDataSource

internal class RemindersRepository(
    private val localDataSource: LocalDataSource
) {
    val reminders: List<Reminder>
        get() = localDataSource.getAllTasks().map { it.map() }

    fun createReminder(title: String) {
        localDataSource.insertTask(title)
    }

    fun markReminder(id: Long, isCompleted: Boolean) {
        if (isCompleted) {
            localDataSource.markTaskCompleted(id)
        } else {
            localDataSource.markTaskPending(id)
        }
    }
}