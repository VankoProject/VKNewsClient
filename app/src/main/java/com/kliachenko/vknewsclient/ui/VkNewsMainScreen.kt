package com.kliachenko.vknewsclient.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kliachenko.domain.FeedPost

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val feedPost = remember {
        mutableStateOf(FeedPost())
    }

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val selectedItemPosition = remember {
                    mutableStateOf(0)
                }
                val items = listOf(
                    NavigationIcon.Home,
                    NavigationIcon.Favourite,
                    NavigationIcon.Profile
                )
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedItemPosition.value == index,
                        onClick = { selectedItemPosition.value = index },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) {
        CardGroupInfo(
            modifier = Modifier.padding(8.dp),
            feedPost = feedPost.value,
            onStatisticsItemClickListener = { newItem ->
                val oldStatistics = feedPost.value.statistics
                val newStatistics = oldStatistics.toMutableList().apply {
                    replaceAll { oldItem ->
                        if (oldItem.type == newItem.type) {
                            oldItem.copy(count = oldItem.count + 1)
                        } else {
                            oldItem
                        }
                    }
                }
                feedPost.value = feedPost.value.copy(statistics = newStatistics)
            }
        )
    }
}