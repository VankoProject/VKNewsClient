package com.kliachenko.vknewsclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.kliachenko.vknewsclient.ui.MainScreen
import com.kliachenko.vknewsclient.ui.theme.VKNewsClientTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VKNewsClientTheme {
                val authLauncher = rememberLauncherForActivityResult(
                    contract = VK.getVKAuthActivityResultContract(),
                ) {
                    when (it) {
                        is VKAuthenticationResult.Success -> {
                            Log.d("MainActivity", "Auth success")
                        }
                        is VKAuthenticationResult.Failed -> {
                            Log.d("MainActivity", "Auth failed")
                        }
                    }
                }
                SideEffect {
                    authLauncher.launch(listOf(VKScope.WALL))
                }
                MainScreen()
            }
        }
    }
}

