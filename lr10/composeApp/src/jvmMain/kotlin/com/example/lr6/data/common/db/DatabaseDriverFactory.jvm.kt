package com.example.lr6.data.common.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.example.lr6.Organise
import java.io.File

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        val dbPath = "${System.getProperty("user.home")}/.organise/organise.db"
        File(dbPath).parentFile?.mkdirs()
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:$dbPath")
        if (!File(dbPath).exists()) {
            Organise.Schema.create(driver)
        }
        return driver
    }
}