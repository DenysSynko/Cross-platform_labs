package com.example.lr6.di

import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import com.russhwolf.settings.Settings
import com.russhwolf.settings.ObservableSettings
import com.example.lr6.data.about.Platform
import com.example.lr6.data.about.AboutRepository
import com.example.lr6.data.common.preferences.AppPreferences
import com.example.lr6.data.common.preferences.Preferences
import com.example.lr6.ui.about.AboutViewModel

private fun createSettings(): Settings = Settings()

val dataModule = module {
    single { createSettings() }
    single<Preferences> {
        val baseSettings = get<Settings>()
        AppPreferences(
            settings = baseSettings,
            observableSettings = baseSettings as? ObservableSettings
        )
    }
}

val appModule = module {
    includes(dataModule)

    singleOf(::Platform)
    singleOf(::AboutRepository)
    factory { AboutViewModel(get()) }
}