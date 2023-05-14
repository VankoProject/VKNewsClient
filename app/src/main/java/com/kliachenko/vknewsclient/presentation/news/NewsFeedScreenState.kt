package com.kliachenko.vknewsclient.presentation.news

import com.kliachenko.vknewsclient.domain.entity.FeedPost

sealed class NewsFeedScreenState {

    object Initial : NewsFeedScreenState()

    object Loading: NewsFeedScreenState()

    data class Posts(
        val posts: List<FeedPost>,
        val nextDataIsLoading: Boolean = false
    ) : NewsFeedScreenState()

}