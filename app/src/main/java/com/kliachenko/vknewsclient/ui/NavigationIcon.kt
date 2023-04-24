package com.kliachenko.vknewsclient.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.kliachenko.vknewsclient.R

sealed class NavigationIcon(
    val titleResId: Int,
    val icon: ImageVector
) {
    object Home : NavigationIcon(
        titleResId = R.string.navigation_item_main,
        icon = Icons.Outlined.Home
    )

    object Favourite : NavigationIcon(
        titleResId = R.string.navigation_item_favourite,
        icon = Icons.Outlined.Favorite
    )

    object Profile : NavigationIcon(
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person
    )
}