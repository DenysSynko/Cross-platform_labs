package com.example.lr6.data.about

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class Platform() {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val cpuType: String
    val screen: ScreenInfo
    fun logSystemInfo()
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class ScreenInfo() {
    val width: Int
    val height: Int
    val density: Int?
}