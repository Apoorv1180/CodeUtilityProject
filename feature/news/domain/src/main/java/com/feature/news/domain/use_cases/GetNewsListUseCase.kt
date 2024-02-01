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

    operator fun invoke(country: String, category: String, apiKey: String) =
        flow<UiEvent<List<News>>> {
            emit(UiEvent.Loading())
            emit(UiEvent.Success(newsRepository.getNewsList(country, category, apiKey)))
        }.catch {
            emit(UiEvent.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)
}