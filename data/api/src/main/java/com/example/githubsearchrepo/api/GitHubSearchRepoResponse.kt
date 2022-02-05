package com.example.githubsearchrepo.api

import androidx.annotation.Keep
import com.example.githubsearchrepo.model.GitHubRepo
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class GitHubSearchRepoResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<GitHubRepo>
)
