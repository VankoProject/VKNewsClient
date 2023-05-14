package com.kliachenko.vknewsclient.domain.usecases

import com.kliachenko.vknewsclient.domain.repository.NewsFeedRepository
import javax.inject.Inject

class LoadNextDataUseCase @Inject constructor(
    private val repository: NewsFeedRepository
) {

    suspend operator fun invoke() {
        repository.loadNextData()
    }
}