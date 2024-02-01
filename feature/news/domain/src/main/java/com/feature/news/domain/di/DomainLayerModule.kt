package com.feature.news.domain.di

import com.feature.news.domain.repo.NewsRepository
import com.feature.news.domain.use_cases.GetNewsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {
    @Provides
    fun provideGetNewsListUseCase(newsRepository: NewsRepository): GetNewsListUseCase =
        GetNewsListUseCase(newsRepository)
}