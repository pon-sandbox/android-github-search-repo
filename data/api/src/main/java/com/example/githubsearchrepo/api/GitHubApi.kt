package com.example.githubsearchrepo.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("/search/repositories")
    suspend fun searchRepository(@Query("q") keyword: String): Response<GitHubSearchRepoResponse>
}