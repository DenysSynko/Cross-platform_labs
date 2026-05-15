package com.example.lr6.data.about

import kotlinx.browser.window

actual class Platform actual constructor() {
    actual val osName: String = "Web Browser"
    actual val osVersion: String = window.navigator.userAgent.substringBefore(" ").substringAfter("(")
    actual val deviceModel: String = window.navigator.appName

    actual val cpuType: String = "${window.navigator.hardwareConcurrency} cores"

    actual val screen: ScreenInfo = ScreenInfo()
    actual fun logSystemInfo() {
        println("Web Platform Info Logged")
    }
}

actual class ScreenInfo actual constructor() {
    actual val width: Int = window.screen.width
    actual val height: Int = window.screen.height
    actual val density: Int? = (window.devicePixelRatio * 160).toInt()
}