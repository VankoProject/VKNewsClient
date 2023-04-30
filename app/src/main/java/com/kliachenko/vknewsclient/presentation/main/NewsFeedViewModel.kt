package com.kliachenko.vknewsclient.presentation.main

import android.app.Application
import androidx.lifecycle.*
import com.kliachenko.vknewsclient.data.mapper.NewsFeedMapper
import com.kliachenko.vknewsclient.data.network.ApiFactory
import com.kliachenko.vknewsclient.domain.FeedPost
import com.kliachenko.vknewsclient.domain.StatisticItem
import com.kliachenko.vknewsclient.presentation.news.NewsFeedScreenState
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import kotlinx.coroutines.launch

class NewsFeedViewModel(application: Application) : AndroidViewModel(application) {

    private val initialState = NewsFeedScreenState.Initial

    private val _screenState = MutableLiveData<NewsFeedScreenState>(initialState)
    val screenState: LiveData<NewsFeedScreenState> = _screenState

    private val mapper = NewsFeedMapper()

    init {
        loadRecommendations()
    }

    private fun loadRecommendations() {
        viewModelScope.launch {
            val storage = VKPreferencesKeyValueStorage(getApplication())
            val token = VKAccessToken.restore(storage) ?: return@launch
            val response = ApiFactory.apiService.loadRecommendation(token.accessToken)
            val feedPosts = mapper.mapResponseToPosts(response)
            _screenState.value = NewsFeedScreenState.Posts(posts = feedPosts)
        }
    }

    fun updateCount(
        item: StatisticItem,
        feedPost: FeedPost
    ) {

        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = NewsFeedScreenState.Posts(posts = newPosts)
    }

    fun remove(feedPost: FeedPost) {

        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        oldPosts.remove(feedPost)
        _screenState.value = NewsFeedScreenState.Posts(posts = oldPosts)
    }
}