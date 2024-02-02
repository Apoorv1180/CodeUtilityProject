package com.example.codeutilityproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.codeutilityproject.navigation.AppNavGraph
import com.example.codeutilityproject.navigation.NavigationProvider
import com.example.codeutilityproject.ui.theme.CodeUtilityProjectTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// MainActivity is the entry point of the app and is annotated with @AndroidEntryPoint for Hilt support
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Inject the NavigationProvider using Dagger Hilt
    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content of the activity using the CodeUtilityProjectTheme
        setContent {
            CodeUtilityProjectTheme {
                // A surface container using the 'background' color from the theme
                // Create a NavController using rememberNavController
                val navController = rememberNavController()
                // Initialize the App composable with the NavController and NavigationProvider
                App(navController, navigationProvider)
            }
        }
    }
}

// App is a composable function representing the overall structure of the app
@Composable
fun App(navHostController: NavHostController, navigationProvider: NavigationProvider) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        // Use the AppNavGraph composable to define the app's navigation graph
        AppNavGraph(navController = navHostController, navigationProvider = navigationProvider)
    }
}