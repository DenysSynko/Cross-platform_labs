package com.example.lr6.di

import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import com.example.lr6.data.about.Platform
import com.example.lr6.data.about.AboutRepository
import com.example.lr6.ui.about.AboutViewModel

val appModule = module {
    singleOf(::Platform)
    singleOf(::AboutRepository)
    viewModelOf(::AboutViewModel)
}