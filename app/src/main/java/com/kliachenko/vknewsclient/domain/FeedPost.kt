package com.kliachenko.vknewsclient.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class FeedPost(
    val id: String,
    val communityName: String,
    val publicationDate: String,
    val communityImageUrl: String,
    val contentText: String,
    val contentImageUrl: String?,
    val statistics: List<StatisticItem>
)
