package com.example.lr6.data.about

class AboutRepository(private val platform: Platform) {

    fun getPlatformData(): List<Pair<String, String>> {
        return listOf(
            "Operating System" to "${platform.osName} ${platform.osVersion}",
            "Device Model" to platform.deviceModel,
            "CPU" to platform.cpuType,
            "Display" to "${platform.screen.width}×${platform.screen.height} (${platform.screen.density} dpi)"
        )
    }
}