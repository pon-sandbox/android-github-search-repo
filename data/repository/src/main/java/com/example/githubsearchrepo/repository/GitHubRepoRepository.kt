package com.example.githubsearchrepo.repository

import com.example.githubsearchrepo.api.GitHubApi
import com.example.githubsearchrepo.model.GitHubRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GitHubRepoRepository @Inject constructor(private val gitHubApi: GitHubApi) {
    suspend fun searchGitHubRepos(keyword: String): List<GitHubRepo> {
        return withContext(Dispatchers.IO) {
            gitHubApi.searchRepository(keyword).body()?.items ?: listOf()
        }
    }
}