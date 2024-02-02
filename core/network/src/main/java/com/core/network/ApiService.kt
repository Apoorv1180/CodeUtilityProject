package com.core.network

import com.core.network.model.NewsListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // Retrofit GET request to retrieve top headlines
    @GET("v2/top-headlines")
    suspend fun getNewsList(
        // Query parameters for country, category, and API key
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): NewsListResponse
}