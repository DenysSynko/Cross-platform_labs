package com.example.lr6.ui.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lr6.data.about.AboutRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AboutViewModel(
    private val aboutRepository: AboutRepository = AboutRepository()
) : ViewModel() {

    private val _state = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val state: StateFlow<List<Pair<String, String>>> = _state

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = aboutRepository.getPlatformData()
        }
    }
}