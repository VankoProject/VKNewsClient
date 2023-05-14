package com.kliachenko.vknewsclient.presentation.comments

import android.app.Application
import androidx.lifecycle.ViewModel
import com.kliachenko.vknewsclient.data.repository.NewFeedRepository
import com.kliachenko.vknewsclient.domain.FeedPost
import kotlinx.coroutines.flow.map

class CommentsViewModel(
    feedPost: FeedPost,
    application: Application
) : ViewModel() {

    private val repository = NewFeedRepository(application = application)

    val screenState = repository.getComments(feedPost)
        .map {
            CommentsScreenState.Comments(
                feedPost = feedPost,
                comments = it
            )
        }
}