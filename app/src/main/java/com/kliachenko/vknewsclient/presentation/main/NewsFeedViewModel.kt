package com.kliachenko.vknewsclient.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kliachenko.vknewsclient.data.repository.NewFeedRepository
import com.kliachenko.vknewsclient.domain.FeedPost
import com.kliachenko.vknewsclient.extentions.mergeWith
import com.kliachenko.vknewsclient.presentation.news.NewsFeedScreenState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsFeedViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NewFeedRepository(application)

    private val recommendationsFlow = repository.recommendations

    private val loadNextDataFlow = MutableSharedFlow<NewsFeedScreenState>()


    val screenState = recommendationsFlow
        .filter { it.isNotEmpty() }
        .map { NewsFeedScreenState.Posts(posts = it) as NewsFeedScreenState }
        .onStart { emit(NewsFeedScreenState.Loading) }
        .mergeWith(loadNextDataFlow)

    fun loadNextRecommendations() {
        viewModelScope.launch {
            loadNextDataFlow.emit(
                NewsFeedScreenState.Posts(
                    posts = recommendationsFlow.value,
                    nextDataIsLoading = true
                )
            )
            repository.loadNextData()
        }
    }

    fun changeLikeStatus(feedPost: FeedPost) {
        viewModelScope.launch {
            repository.changeLikeStatus(feedPost)
        }
    }

    fun remove(feedPost: FeedPost) {
        viewModelScope.launch {
            repository.deletePost(feedPost)
        }
    }
}