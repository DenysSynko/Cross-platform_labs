package com.example.lr6.data.about

import java.awt.Toolkit

actual class Platform actual constructor() {
    actual val osName: String = System.getProperty("os.name") ?: "Desktop"
    actual val osVersion: String = System.getProperty("os.version") ?: "Unknown"
    actual val deviceModel: String = System.getProperty("os.arch") ?: "Unknown"
    actual val cpuType: String = System.getenv("PROCESSOR_IDENTIFIER") ?: "Unknown"

    actual val screen: ScreenInfo = ScreenInfo()
    actual fun logSystemInfo() {}
}

actual class ScreenInfo actual constructor() {
    private val toolkit = Toolkit.getDefaultToolkit()
    actual val width: Int = toolkit.screenSize.width
    actual val height: Int = toolkit.screenSize.height
    actual val density: Int? = toolkit.screenResolution
}