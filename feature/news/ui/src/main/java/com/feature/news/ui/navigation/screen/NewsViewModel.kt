package com.feature.news.ui.navigation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
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


    private val _newsList = mutableStateOf(NewsStateHolder())
    val newsList: State<NewsStateHolder> get() = _newsList

    init {
        getNewsList(
        )
    }

    fun getNewsList(
    ) = viewModelScope.launch {
        getNewsListUseCase(country, category, API_KEY)
            .onEach { event ->
                when (event) {
                    is UiEvent.Error -> {
                        _newsList.value = NewsStateHolder(error = event.message.toString())
                    }

                    is UiEvent.Loading -> {
                        _newsList.value = NewsStateHolder(isLoading = true)
                    }

                    is UiEvent.Success -> {
                        _newsList.value = NewsStateHolder(data = event.data)
                    }
                }

            }
            .launchIn(viewModelScope)
    }

    companion object {
        // for a normal scenario hardcoding the values for below:
        private val country: String = "in"
        private val category: String = "sports"
        private val API_KEY: String = "ddb49c14f81a4b4e96e8f66120c33f92"

    }

}