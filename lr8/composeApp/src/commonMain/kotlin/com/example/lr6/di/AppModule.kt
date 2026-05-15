package com.example.lr6.di

import org.koin.dsl.module
import com.example.lr6.data.about.Platform
import com.example.lr6.data.about.AboutRepository
import com.example.lr6.ui.about.AboutViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf

val appModule = module {
    single { Platform() }
    single { AboutRepository(get()) }
    viewModelOf(::AboutViewModel)
}