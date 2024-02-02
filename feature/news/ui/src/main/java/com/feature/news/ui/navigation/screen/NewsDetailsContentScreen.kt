package com.feature.news.ui.navigation.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.feature.news.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailsContentScreen(navController: NavHostController, viewModel: NewsViewModel) {
    // Retrieve the selected news from the view model
    val selectedNews = viewModel.selectedNews.value

    // Scaffold is a Material3 component providing a basic layout structure
    Scaffold(
        topBar = {
            // TopAppBar is a Material3 component for displaying a top app bar
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.appName))
                },
                // Customize top app bar colors using Material3 theme
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                // Navigation icon for navigating back
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) {
        // Column is a Compose layout component to arrange children vertically
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(16.dp)
        ) {
            // Title
            Text(
                text = selectedNews?.title ?: "No title available",
                style = MaterialTheme.typography.titleLarge
            )

            // Description
            if (!selectedNews?.description.isNullOrBlank()) {
                Text(
                    text = selectedNews?.description ?: stringResource(R.string.na),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp, top = 8.dp),
                    color = Color.DarkGray
                )
            }

            // PublishedAt
            Text(
                text = "Published at: ${selectedNews?.publishedAt}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)
            )

            // Author
            if (!selectedNews?.author.isNullOrBlank()) {
                Text(
                    text = "${stringResource(id = R.string.Author)}: ${selectedNews?.author}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)
                )
            }

            // URL
            if (!selectedNews?.url.isNullOrBlank()) {
                Text(
                    text = "URL: ${selectedNews?.url}",
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 8.dp)
                )
            }
        }
    }
}

