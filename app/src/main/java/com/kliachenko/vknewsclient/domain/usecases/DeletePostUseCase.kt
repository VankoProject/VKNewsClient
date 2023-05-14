package com.kliachenko.vknewsclient.domain.usecases

import com.kliachenko.vknewsclient.domain.entity.FeedPost
import com.kliachenko.vknewsclient.domain.repository.NewsFeedRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val repository: NewsFeedRepository
) {

    suspend operator fun invoke(feedPost: FeedPost) {
        repository.deletePost(feedPost)
    }
}