package com.core.common.navigation_constants

// Object representing navigation constants for the News feature
object NewsFeature {
    // Route for the nested navigation graph of the News feature
    const val nestedRoute = "news_nested_route"
    // Route for the main News screen
    const val newsScreenRoute = "news_screen_route"
    // Route for the News details screen with a dynamic title parameter
    const val newsDetailsRoute = "news_detail_screen_route/{title}"
}