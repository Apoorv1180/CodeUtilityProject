package com.core.network.model

data class NewsListResponse(
    val articles: List<NewsDTO>,
    val status: String,
    val totalResults: Int
)