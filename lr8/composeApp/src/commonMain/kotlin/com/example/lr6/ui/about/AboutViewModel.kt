package com.example.lr6.ui.about

import androidx.lifecycle.ViewModel
import com.example.lr6.data.about.AboutRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AboutViewModel(aboutRepository: AboutRepository) : ViewModel() {

    private val _state = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val state: StateFlow<List<Pair<String, String>>> = _state

    init {
        _state.value = aboutRepository.getPlatformData()
    }
}