package com.feature.news.data.mapper

import com.core.network.model.NewsListResponse
import com.feature.news.domain.model.News
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Extension function to convert a NewsListResponse to a List of domain News objects
fun NewsListResponse.toDomainNewsList(): List<News> {
    // Map each article in the response to a News domain object
    return this.articles.map {
        News(
            title = it.title,            // Extracting title from the article
            description = it.description,  // Extracting description from the article
            author = it.author,          // Extracting author from the article
            publishedAt = it.publishedAt.toReadableDate(),  // Extracting publishedAt from the article
            url = it.url                 // Extracting URL from the article
        )
    }
}

// Extension function to convert a date string in the format "yyyy-MM-dd'T'HH:mm:ss'Z'"
fun String.toReadableDate(): String {
    // Define the input and output date formats
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.getDefault())

    return try {
        // Parse the input date string
        val date: Date = inputFormat.parse(this) ?: Date()

        // Format the parsed date to the desired output format
        outputFormat.format(date)
    } catch (e: Exception) {
        // Handle parsing errors and return a fallback value
        "Invalid Date"
    }
}