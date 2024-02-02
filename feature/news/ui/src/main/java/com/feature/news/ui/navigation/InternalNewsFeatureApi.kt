package com.feature.news.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.core.common.navigation_constants.NewsFeature
import com.core.feature_api.FeatureApi
import com.feature.news.ui.navigation.screen.NewsDetailsContentScreen
import com.feature.news.ui.navigation.screen.NewsScreen
import com.feature.news.ui.navigation.screen.NewsViewModel

// InternalNewsFeatureApi is an implementation of FeatureApi for the News feature
internal object InternalNewsFeatureApi : FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        // Set up the nested navigation for the News feature
        navGraphBuilder.navigation(
            startDestination = NewsFeature.newsScreenRoute,
            route = NewsFeature.nestedRoute
        ) {

            // Define the composable for the main News screen
            composable(NewsFeature.newsScreenRoute) {
                val viewModel = hiltViewModel<NewsViewModel>()
                NewsScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            // Define the composable for the News details screen with a dynamic title argument
            composable(
                route = "${NewsFeature.newsDetailsRoute}/{title}",
                arguments = listOf(navArgument("title") { type = NavType.StringType })
            ) { backStackEntry ->
                val viewModel = hiltViewModel<NewsViewModel>()
                // Extract the title argument from the navigation entry
                val title = backStackEntry.arguments?.getString("title")
                // Set the selected news in the view model based on the title
                viewModel.setSelectedNews(viewModel.getNewsByTitle(title))
                // Navigate to the News details content screen
                NewsDetailsContentScreen(navController = navController, viewModel = viewModel)
            }
        }
    }
}