package com.kliachenko.vknewsclient.domain

import com.kliachenko.vknewsclient.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.ic_launcher_background,
    val contentText: String = "It is a new post from Kiev",
    val contentImageResId: Int = R.drawable.kyiv_neperemojny,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 966),
        StatisticItem(type = StatisticType.SHARES, 7),
        StatisticItem(type = StatisticType.COMMENTS, 8),
        StatisticItem(type = StatisticType.LIKES, 27)
    )
)
