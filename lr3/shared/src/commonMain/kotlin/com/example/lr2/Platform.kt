package com.example.lr2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform