package com.feature.news.ui.navigation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.news.domain.model.News
import com.feature.news.domain.use_cases.GetNewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase
) : ViewModel() {

    // Mutable state to hold the current state of the news list
    private val _newsList = mutableStateOf(NewsStateHolder())

    // Publicly exposed state of the news list
    val newsList: State<NewsStateHolder> get() = _newsList

    // Mutable state to hold the selected news item
    private val _selectedNews = mutableStateOf<News?>(null)

    // Publicly exposed state of the selected news item
    val selectedNews: State<News?> get() = _selectedNews

    // Initialization block, fetching the news list on ViewModel creation
    init {
        getNewsList()
    }

    // Function to fetch the news list from the use case
    fun getNewsList() = viewModelScope.launch {
        // Call the use case with hardcoded parameters
        getNewsListUseCase(country, category, API_KEY)
            .onEach { event ->
                when (event) {
                    // Handle the error event
                    is UiEvent.Error -> {
                        _newsList.value = NewsStateHolder(error = event.message.toString())
                    }

                    // Handle the loading event
                    is UiEvent.Loading -> {
                        _newsList.value = NewsStateHolder(isLoading = true)
                    }

                    // Handle the success event
                    is UiEvent.Success -> {
                        _newsList.value = NewsStateHolder(data = event.data)
                    }
                }

            }
            .launchIn(viewModelScope)
    }

    // Function to retrieve news by title
    fun getNewsByTitle(title: String?): News? {
        return newsList.value.data?.find { it.title == title }
    }

    // Function to set the selected news item
    fun setSelectedNews(news: News?) {
        _selectedNews.value = news
    }

    companion object {
        // Hardcoded values for country, category, and API key
        private const val country: String = "in"
        private const val category: String = "sports"
        private const val API_KEY: String = "ddb49c14f81a4b4e96e8f66120c33f92"
    }
}