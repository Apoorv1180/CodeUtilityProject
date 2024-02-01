package com.feature.news.data.mapper

import com.core.network.model.NewsListResponse
import com.feature.news.domain.model.News

fun NewsListResponse.toDomainNewsList(): List<News> {
    return this.articles.map {
        News(
            title = it.title,
            description = it.description,
            author = it.author
        )
    }
}