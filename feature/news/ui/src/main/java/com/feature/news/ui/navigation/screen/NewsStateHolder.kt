package com.feature.news.ui.navigation.screen

import com.feature.news.domain.model.News

// Data class representing the state of the news list in the ViewModel
data class NewsStateHolder(
    // Flag indicating whether the news list is currently being loaded
    val isLoading: Boolean = false,

    // List of news data (nullable)
    val data: List<News>? = null,

    // Error message (empty string by default)
    val error: String = ""
)