package com.kliachenko.vknewsclient.ui

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage

@Composable
fun ActivityResultTest() {
    var imageURI by remember {
        mutableStateOf(Uri.EMPTY)
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            imageURI = it
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding()
    ) {
        AsyncImage(
            modifier = Modifier.weight(1f),
            model = imageURI,
            contentDescription = null
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ),
            onClick = {
                launcher.launch("image/*")
            }
        ) {
            Text(text = "Get Image")
        }
    }
}

