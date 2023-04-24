package com.kliachenko.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kliachenko.vknewsclient.ui.MainScreen
import com.kliachenko.vknewsclient.ui.theme.VKNewsClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKNewsClientTheme {
                MainScreen()
            }
        }
    }
}

