package com.kliachenko.vknewsclient.presentation.news

import com.kliachenko.vknewsclient.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial: NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()

}