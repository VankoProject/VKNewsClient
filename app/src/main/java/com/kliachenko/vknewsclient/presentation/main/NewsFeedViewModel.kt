package com.kliachenko.vknewsclient.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kliachenko.vknewsclient.domain.FeedPost
import com.kliachenko.vknewsclient.domain.StatisticItem
import com.kliachenko.vknewsclient.presentation.news.NewsFeedScreenState

class NewsFeedViewModel : ViewModel() {

    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(
                    id = it,
                    contentText = "Content $it"
                )
            )
        }
    }
    private val initialState = NewsFeedScreenState.Posts(posts = sourceList)

    private val _screenState = MutableLiveData<NewsFeedScreenState>(initialState)
    val screenState: LiveData<NewsFeedScreenState> = _screenState

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