package com.feature.news.ui.navigation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.feature.news.domain.model.News
import com.feature.news.ui.R

@Composable
fun NewsScreen(viewModel: NewsViewModel) {
    // Observe the newsList from the viewModel
    val result = viewModel.newsList.value

    // LaunchedEffect to trigger loading when the screen is first displayed
    LaunchedEffect(viewModel) {
        // fetch news in your ViewModel after refresh button click
        viewModel.getNewsList()
    }

    // Scaffold for the app structure
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "${stringResource(id = R.string.appName)}") },
                actions = {
                    // Refresh button to manually trigger news refresh
                    IconButton(
                        onClick = { viewModel.getNewsList() },
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "${stringResource(id = R.string.refresh)}"
                        )
                    }
                }
            )
        }
    ) {
        // Display different UI based on the state
        Log.d("TAG", "NewsScreen ${it}")
        when {
            result.isLoading -> {
                // Loading state
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .wrapContentSize(Alignment.Center)
                )
            }

            result.data != null -> {
                // News data available
                NewsList(newsList = result.data)
            }

            else -> {
                // Error state
                ErrorState(error = result.error)
            }
        }
    }
}

@Composable
fun NewsList(newsList: List<News>) {
    LazyColumn {
        items(newsList) { news ->
            NewsCard(news = news)
        }
    }
}

@Composable
fun NewsCard(news: News) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Title
            Text(
                text = news.title,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Description
            if (!news.description.isNullOrBlank()) {
                Text(
                    text = news.description ?: stringResource(R.string.na),
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            // Author
            if (!news.author.isNullOrBlank()) {
                Text(
                    text = "${stringResource(id = R.string.Author)}: ${news.author}",
                    style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

@Composable
fun ErrorState(error: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.error),
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = error,
            style = TextStyle(fontSize = 16.sp),
            textAlign = TextAlign.Center
        )
    }
}