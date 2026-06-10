package com.example.lr6.data.about

import co.touchlab.kermit.Logger
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import kotlinx.cinterop.useContents
import kotlinx.cinterop.ExperimentalForeignApi

actual class Platform actual constructor() {
actual val osName: String = UIDevice.currentDevice.systemName
actual val osVersion: String = UIDevice.currentDevice.systemVersion
actual val deviceModel: String = UIDevice.currentDevice.model
actual val cpuType: String = "ARM64"
actual val screen: ScreenInfo = ScreenInfo()

actual fun logSystemInfo() {
Logger.d("Platform: $deviceInfo")
}
}

actual class ScreenInfo actual constructor() {
@OptIn(ExperimentalForeignApi::class)
actual val width: Int = UIScreen.mainScreen.bounds.useContents { size.width.toInt() }

@OptIn(ExperimentalForeignApi::class)
actual val height: Int = UIScreen.mainScreen.bounds.useContents { size.height.toInt() }

actual val density: Int? = UIScreen.mainScreen.scale.toInt()
}