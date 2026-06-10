package com.example.lr2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lr2.data.common.NetworkResult
import com.example.lr2.domain.repository.Repository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

data class UiState(val isLoading: Boolean = false, val result: String = "", val error: String = "")
@Serializable
data class PostRequest(val title: String, val body: String, val userId: Int)
class AppViewModel(private val repo: Repository) : ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    private fun run(action: suspend () -> NetworkResult<String>) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = "") }
            when (val res = action()) {
                is NetworkResult.Success -> _state.update { it.copy(isLoading = false, result = res.data) }
                is NetworkResult.Failure -> _state.update { it.copy(isLoading = false, error = res.errorMessage) }
            }
        }
    }

    fun getPosts() = run { repo.getPosts() }

    fun addPost() {
        val newPost = PostRequest(
            title = "TITLE",
            body = "TEXT TO POST",
            userId = 1
        )
        run { repo.addPost(newPost) }
    }

    fun updatePost() = run { repo.updatePost() }
    fun deletePost() = run { repo.deletePost() }
}