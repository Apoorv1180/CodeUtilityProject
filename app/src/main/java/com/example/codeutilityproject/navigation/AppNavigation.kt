package com.example.codeutilityproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constants.NewsFeature

@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {

    NavHost(navController = navController, startDestination = NewsFeature.nestedRoute) {
        navigationProvider.newsApi.registerGraph(navController, this)
    }
}