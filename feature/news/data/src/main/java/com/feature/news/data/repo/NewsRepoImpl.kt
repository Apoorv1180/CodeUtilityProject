package com.feature.news.data.repo

import com.core.network.dataproviders.NewsDataProviders
import com.feature.news.data.mapper.toDomainNewsList
import com.feature.news.domain.model.News
import com.feature.news.domain.repo.NewsRepository
import javax.inject.Inject

class NewsRepoImpl @Inject constructor
    (private val newsDataProviders: NewsDataProviders) : NewsRepository {
    override suspend fun getNewsList(
        country: String,
        category: String,
        apiKey: String
    ): List<News> = newsDataProviders.getNewsList(country, category, apiKey).toDomainNewsList()

}