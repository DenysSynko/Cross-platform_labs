package com.example.lr2.di

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.*
import org.koin.dsl.*
import com.example.lr2.data.api.ApiService
import com.example.lr2.domain.repository.Repository
import com.example.lr2.presentation.AppViewModel

val networkModule = module {
    single {
        HttpClient {
            install(Logging) { level = LogLevel.ALL }
            install(ContentNegotiation) {
                json(Json { prettyPrint = true; isLenient = true; ignoreUnknownKeys = true })
            }
        }
    }
    singleOf(::ApiService)
}

val appModule = module {
    includes(networkModule)
    singleOf(::Repository)
    viewModelOf(::AppViewModel)
}