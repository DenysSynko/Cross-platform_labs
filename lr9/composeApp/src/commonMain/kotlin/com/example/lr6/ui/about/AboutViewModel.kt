package com.example.lr6.ui.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.char
import com.example.lr6.data.about.AboutRepository

internal class AboutViewModel(
    private val aboutRepository: AboutRepository,
) : ViewModel() {

    // Створюємо формат дати: ДД.ММ.РРРР ГГ:ХХ
    private val dateTimeFormat = LocalDateTime.Format {
        day()
        char('.')
        monthNumber()
        char('.')
        year()
        char(' ')
        hour()
        char(':')
        minute()
    }

    private val _state = MutableStateFlow(AboutState())
    val state = _state.asStateFlow()

    init {
        // Коли відкриваємо екран:
        aboutRepository.increaseVisitCount() // Збільшуємо лічильник
        aboutRepository.updateVisitedDate()  // Оновлюємо дату візиту
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val platformInfo = aboutRepository.getPlatformData()
            val visitedCount = aboutRepository.visitedCount()
            // Форматуємо дату в красивий рядок
            val lastVisitedDate = aboutRepository.visitedDate()?.format(dateTimeFormat) ?: "-----"

            _state.update { current ->
                current.copy(
                    platformInfo = platformInfo,
                    visitedCount = visitedCount,
                    visitedDate = lastVisitedDate
                )
            }
        }
    }
}