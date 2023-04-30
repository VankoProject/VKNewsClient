package com.kliachenko.vknewsclient.data.model

import com.google.gson.annotations.SerializedName

data class NewsFeedResponseDto(
    @SerializedName("response") val newsFeedContentDto: NewsFeedContentDto
)
