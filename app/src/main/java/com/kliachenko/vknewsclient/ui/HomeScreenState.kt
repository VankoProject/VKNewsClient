package com.kliachenko.vknewsclient.ui

import com.kliachenko.domain.FeedPost
import com.kliachenko.domain.PostComment

sealed class HomeScreenState {

    object Initial: HomeScreenState()

    data class Posts(val posts: List<FeedPost>) : HomeScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
        ) : HomeScreenState()

}