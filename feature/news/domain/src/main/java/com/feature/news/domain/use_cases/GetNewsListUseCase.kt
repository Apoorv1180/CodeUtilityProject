package com.feature.news.domain.use_cases

import com.core.common.UiEvent
import com.feature.news.domain.model.News
import com.feature.news.domain.repo.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    // Operator function to invoke the use case
    operator fun invoke(country: String, category: String, apiKey: String) =
        flow<UiEvent<List<News>>> {
            // Emit a loading event to indicate the start of the operation
            emit(UiEvent.Loading())
            // Fetch news list from the repository and emit a success event with the result
            emit(UiEvent.Success(newsRepository.getNewsList(country, category, apiKey)))
        }.catch {
            // Catch any exceptions during the operation and emit an error event
            emit(UiEvent.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO) // Execute the flow on the IO dispatcher
}