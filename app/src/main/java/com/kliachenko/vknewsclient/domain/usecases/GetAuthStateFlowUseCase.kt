package com.kliachenko.vknewsclient.domain.usecases

import androidx.compose.runtime.referentialEqualityPolicy
import com.kliachenko.vknewsclient.domain.entity.AuthState
import com.kliachenko.vknewsclient.domain.repository.NewsFeedRepository
import kotlinx.coroutines.flow.StateFlow

class GetAuthStateFlowUseCase(
   private val repository: NewsFeedRepository
) {

    operator fun invoke(): StateFlow<AuthState> {
        return repository.getAuthStateFlow()
    }
}