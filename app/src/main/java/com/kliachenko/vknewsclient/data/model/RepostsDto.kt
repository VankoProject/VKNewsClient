package com.kliachenko.vknewsclient.data.model

import com.google.gson.annotations.SerializedName

data class RepostsDto(
    @SerializedName("count") val count: Int
)
