package com.feature.news.data.mapper

import com.core.network.model.NewsListResponse
import com.feature.news.domain.model.News

// Extension function to convert a NewsListResponse to a List of domain News objects
fun NewsListResponse.toDomainNewsList(): List<News> {
    // Map each article in the response to a News domain object
    return this.articles.map {
        News(
            title = it.title,            // Extracting title from the article
            description = it.description,  // Extracting description from the article
            author = it.author,          // Extracting author from the article
            publishedAt = it.publishedAt,  // Extracting publishedAt from the article
            url = it.url                 // Extracting URL from the article
        )
    }
}