package com.example.githubsearchrepo.ui.main

import com.example.githubsearchrepo.model.GitHubRepo

data class MainUiState(
    val repositories: List<GitHubRepo> = listOf()
)
