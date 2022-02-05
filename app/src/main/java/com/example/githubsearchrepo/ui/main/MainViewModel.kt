package com.example.githubsearchrepo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearchrepo.repository.GitHubRepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val gitHubRepoRepository: GitHubRepoRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun searchRepository(keyword: String) {
        viewModelScope.launch {
            _uiState.value = MainUiState(gitHubRepoRepository.searchGitHubRepos(keyword))
        }
    }
}