package com.feature.news.data.di

import com.core.network.dataproviders.NewsDataProviders
import com.feature.news.data.repo.NewsRepoImpl
import com.feature.news.domain.repo.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {
    @Provides
    fun provideNewsRepo(newsDataProviders: NewsDataProviders): NewsRepository =
        NewsRepoImpl(newsDataProviders)
}