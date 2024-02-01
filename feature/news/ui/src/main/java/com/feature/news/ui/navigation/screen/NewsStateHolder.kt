package com.feature.news.ui.navigation.screen

import com.feature.news.domain.model.News

data class NewsStateHolder(
    val isLoading: Boolean = false,
    val data: List<News>? = null,
    val error: String = ""
)