package com.feature.news.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

// Interface representing the News API, extending FeatureApi
interface NewsApi : FeatureApi

// Implementation of the News API
class NewsApiImpl : NewsApi {

    // Override the registerGraph function to provide navigation functionality
    override fun registerGraph(navcontroller: NavHostController, navGraphBuilder: NavGraphBuilder) {
        // Delegate the registration to the internal implementation
        InternalNewsFeatureApi.registerGraph(
            navcontroller, navGraphBuilder
        )
    }
}