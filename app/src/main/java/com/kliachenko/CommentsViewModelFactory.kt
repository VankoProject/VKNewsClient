package com.kliachenko

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kliachenko.domain.FeedPost
import com.kliachenko.vknewsclient.CommentsViewModel

class CommentsViewModelFactory(
    private val feedPost: FeedPost
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommentsViewModel(feedPost) as T
    }
}