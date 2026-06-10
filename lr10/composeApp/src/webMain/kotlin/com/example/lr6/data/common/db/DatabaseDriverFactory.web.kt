package com.example.lr6.data.common.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import org.w3c.dom.Worker

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        val worker = Worker("SqliteWorker.js")
        return WebWorkerDriver(worker)
    }
}