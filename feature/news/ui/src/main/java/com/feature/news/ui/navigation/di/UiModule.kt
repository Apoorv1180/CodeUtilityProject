package com.feature.news.ui.navigation.di

import com.feature.news.ui.navigation.NewsApi
import com.feature.news.ui.navigation.NewsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideNewsApi(): NewsApi = NewsApiImpl()
}