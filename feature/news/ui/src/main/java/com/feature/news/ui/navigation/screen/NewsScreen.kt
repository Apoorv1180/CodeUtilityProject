package com.feature.news.ui.navigation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.core.common.navigation_constants.NewsFeature
import com.feature.news.domain.model.News
import com.feature.news.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(navController: NavHostController, viewModel: NewsViewModel) {
    // Retrieve news list result from the view model
    val result by viewModel.newsList

    // Fetch news list when the composable is launched
    LaunchedEffect(viewModel) {
        viewModel.getNewsList()
    }

    // Scaffold is a Material3 component providing a basic layout structure
    Scaffold(
        topBar = {
            // TopAppBar is a Material3 component for displaying a top app bar
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.appName)) },
                // Customize top app bar colors using Material3 theme
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                // Refresh action button in the top app bar
                actions = {
                    IconButton(
                        onClick = { viewModel.getNewsList() },
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = stringResource(id = R.string.refresh)
                        )
                    }
                }
            )
        }
    ) {
        // Column is a Compose layout component to arrange children vertically
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            // Based on the state of the result, display loading, data, or error state
            when {
                result.isLoading -> {
                    // Display a loading indicator
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .wrapContentSize(Alignment.Center)
                    )
                }

                result.data != null -> {
                    // News data available, display the list of news
                    val newsList = result.data
                    if (newsList != null) {
                        // Display the list of news using the NewsList composable
                        NewsList(newsList = newsList) { selectedNews ->
                            viewModel.setSelectedNews(selectedNews)
                            // Navigate to details screen
                            navController.navigate(
                                "${NewsFeature.newsDetailsRoute}/${
                                    selectedNews.title.toString()
                                }"
                            )
                        }
                    } else {
                        // Display error state if the newsList is null
                        ErrorState(error = result.error)
                    }
                }

                else -> {
                    // Display error state for other cases
                    ErrorState(error = result.error)
                }
            }
        }
    }
}

// NewsList composable to display a list of news using LazyColumn
@Composable
fun NewsList(newsList: List<News>, onItemClick: (News) -> Unit) {
    LazyColumn {
        items(newsList) { news ->
            // Display each news item using the NewsCard composable
            NewsCard(news = news, onItemClick = onItemClick)
        }
    }
}

// NewsCard composable to display an individual news item
@Composable
fun NewsCard(news: News, onItemClick: (News) -> Unit) {
    // ElevatedCard is a Material3 component for displaying elevated card-like surfaces
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(
                onClick = { onItemClick(news) }
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        // Column is a Compose layout component to arrange children vertically
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Title
            Text(
                text = news.title,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Description
            if (!news.description.isNullOrBlank()) {
                Text(
                    text = "Published at: ${news.publishedAt}",
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

// ErrorState composable to display an error message
@Composable
fun ErrorState(error: String) {
    // Column is a Compose layout component to arrange children vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display an error message in bold
        Text(
            text = stringResource(id = R.string.error),
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // Display the specific error message
        Text(
            text = error,
            style = TextStyle(fontSize = 16.sp),
            textAlign = TextAlign.Center
        )
    }
}