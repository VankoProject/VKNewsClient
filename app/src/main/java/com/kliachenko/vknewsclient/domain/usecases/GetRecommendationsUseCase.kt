package com.kliachenko.vknewsclient.domain.usecases

import com.kliachenko.vknewsclient.domain.entity.FeedPost
import com.kliachenko.vknewsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetRecommendationsUseCase(
    private val repository: NewsFeedRepository
) {

    operator fun invoke(): StateFlow<List<FeedPost>> {
        return repository.getRecommendations()
    }

}