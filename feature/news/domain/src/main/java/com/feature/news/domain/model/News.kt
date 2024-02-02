package com.feature.news.domain.model

// Data class representing a news item
data class News(
    // Title of the news
    val title: String,
    // Description of the news (nullable)
    val description: String?,
    // Author of the news (nullable)
    val author: String?,
    // Published date and time of the news
    val publishedAt: String,
    // URL pointing to the full news article
    val url: String
)