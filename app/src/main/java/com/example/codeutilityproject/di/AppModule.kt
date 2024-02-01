package com.example.codeutilityproject.di

import com.example.codeutilityproject.navigation.NavigationProvider
import com.feature.news.ui.navigation.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(newsApi: NewsApi): NavigationProvider =
        NavigationProvider(newsApi)
}