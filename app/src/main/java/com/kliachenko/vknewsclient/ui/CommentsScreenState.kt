package com.kliachenko.vknewsclient.ui

import com.kliachenko.vknewsclient.domain.FeedPost
import com.kliachenko.vknewsclient.domain.PostComment

sealed class CommentsScreenState {
    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()

}