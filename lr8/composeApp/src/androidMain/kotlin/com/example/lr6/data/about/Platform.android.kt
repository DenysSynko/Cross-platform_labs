package com.example.lr6.data.about

import android.os.Build
import android.content.Context
import org.koin.core.context.GlobalContext

actual class Platform actual constructor() {
    private val context: Context by lazy { GlobalContext.get().get<Context>() }

    actual val osName: String = "Android"
    actual val osVersion: String = Build.VERSION.RELEASE
    actual val deviceModel: String = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val cpuType: String = Build.SUPPORTED_ABIS.firstOrNull() ?: "Unknown"

    actual val screen: ScreenInfo by lazy { ScreenInfo(context) }

    actual fun logSystemInfo() {}
}

actual class ScreenInfo(context: Context) {
    private val metrics = context.resources.displayMetrics

    actual val width: Int = metrics.widthPixels
    actual val height: Int = metrics.heightPixels
    actual val density: Int? = metrics.densityDpi

    actual constructor() : this(GlobalContext.get().get<Context>())
}