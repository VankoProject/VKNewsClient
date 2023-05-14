package com.kliachenko.vknewsclient.domain.usecases

import com.kliachenko.vknewsclient.domain.repository.NewsFeedRepository

class CheckAuthStateUseCase(
    private val repository: NewsFeedRepository
) {

    suspend operator fun invoke() {
        repository.checkAuthState()
    }
}