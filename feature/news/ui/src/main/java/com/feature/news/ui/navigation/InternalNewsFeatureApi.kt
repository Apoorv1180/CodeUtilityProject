package com.feature.news.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.NewsFeature
import com.core.feature_api.FeatureApi

internal object InternalNewsFeatureApi : FeatureApi {
    override fun registerGraph(
        navcontroller: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {

        navGraphBuilder.navigation(
            startDestination = NewsFeature.newsScreenRoute,
            route = NewsFeature.nestedRoute
        ) {

            composable(NewsFeature.newsScreenRoute) {


            }
        }
    }


}