package com.example.lr6

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform