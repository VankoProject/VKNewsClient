package com.kliachenko.vknewsclient.presentation.comments

import androidx.lifecycle.ViewModel
import com.kliachenko.vknewsclient.domain.entity.FeedPost
import com.kliachenko.vknewsclient.domain.usecases.GetCommentsUseCase
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CommentsViewModel @Inject constructor(
    private val feedPost: FeedPost,
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {

    val screenState = getCommentsUseCase(feedPost)
        .map {
            CommentsScreenState.Comments(
                feedPost = feedPost,
                comments = it
            )
        }
}