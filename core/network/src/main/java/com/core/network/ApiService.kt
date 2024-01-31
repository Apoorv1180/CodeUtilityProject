package com.core.network

import com.core.network.model.NewsListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=ddb49c14f81a4b4e96e8f66120c33f92
    @GET("v2/top-headlines")
    suspend fun getNewsList(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): NewsListResponse


}