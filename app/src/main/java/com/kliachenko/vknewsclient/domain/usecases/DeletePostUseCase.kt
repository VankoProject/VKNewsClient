package com.kliachenko.vknewsclient.domain.usecases

import com.kliachenko.vknewsclient.domain.entity.FeedPost
import com.kliachenko.vknewsclient.domain.repository.NewsFeedRepository

class DeletePostUseCase(
    private val repository: NewsFeedRepository
) {

    suspend operator fun invoke(feedPost: FeedPost) {
        repository.deletePost(feedPost)
    }
}