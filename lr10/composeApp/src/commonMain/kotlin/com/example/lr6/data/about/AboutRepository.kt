package com.example.lr6.data.about

import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Instant
import com.example.lr6.data.common.preferences.Preferences

class AboutRepository(
    private val platform: Platform,
    private val preferences: Preferences
) {

    fun getPlatformData(): List<Pair<String, String>> {
        return listOf(
            "Operating System" to "${platform.osName} ${platform.osVersion}",
            "Device Model" to platform.deviceModel,
            "CPU" to platform.cpuType,
            "Display" to "${platform.screen.width}×${platform.screen.height} (${platform.screen.density} dpi)"
        )
    }

    fun increaseVisitCount() {
        preferences.aboutVisitedCount++
    }

    fun visitedCount(): Int {
        return preferences.aboutVisitedCount
    }

    fun updateVisitedDate() {
        val now: Instant = Clock.System.now()
        val localNow: LocalDateTime = now.toLocalDateTime(TimeZone.currentSystemDefault())
        preferences.aboutVisitedDate = localNow
    }

    fun visitedDate(): LocalDateTime? {
        return preferences.aboutVisitedDate
    }
}