package com.core.network.dataproviders

import com.core.network.ApiService
import javax.inject.Inject

class NewsDataProviders @Inject constructor(
    private val apiService: ApiService
) {

    // Function to fetch news list from the API service
    suspend fun getNewsList(country: String, category: String, apiKey: String) =
        apiService.getNewsList(country, category, apiKey)
}