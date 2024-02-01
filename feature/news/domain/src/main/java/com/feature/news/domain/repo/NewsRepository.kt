package com.feature.news.domain.repo

import com.feature.news.domain.model.News

interface NewsRepository {

    suspend fun getNewsList(country: String, category: String, apiKey: String): List<News>

}