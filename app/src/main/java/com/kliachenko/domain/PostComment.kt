package com.kliachenko.domain

import com.kliachenko.vknewsclient.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.ic_launcher_background,
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00"
)
