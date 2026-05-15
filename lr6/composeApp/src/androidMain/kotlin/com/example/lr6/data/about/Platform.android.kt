package com.example.lr6.data.about

import android.os.Build
import com.example.lr6.applicationResources

actual class Platform actual constructor() {
    actual val osName: String = "Android"
    actual val osVersion: String = Build.VERSION.RELEASE
    actual val deviceModel: String = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val cpuType: String = Build.SUPPORTED_ABIS.firstOrNull() ?: "Unknown"

    actual val screen: ScreenInfo = ScreenInfo()
    actual fun logSystemInfo() {}
}

actual class ScreenInfo actual constructor() {
    actual val width: Int = applicationResources.displayMetrics.widthPixels
    actual val height: Int = applicationResources.displayMetrics.heightPixels
    actual val density: Int? = applicationResources.displayMetrics.densityDpi
}