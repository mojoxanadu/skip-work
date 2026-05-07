package com.xanadu.skipwork.ui.screens

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.xanadu.skipwork.ui.theme.Beige
import kotlinx.coroutines.delay

@Composable
fun FloorLoadingScreen(onLoadingComplete: () -> Unit) {
    val countdown = remember { mutableStateOf(3) }
    
    LaunchedEffect(Unit) {
        while (countdown.value > 0) {
            delay(1000)
            countdown.value -= 1
        }
        delay(500)
        onLoadingComplete()
    }
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Get ready!",
            color = Beige,
            fontSize = 32.sp
        )
        Text(
            text = countdown.value.toString(),
            color = Beige,
            fontSize = 48.sp
        )
    }
}

@Composable
fun GameActiveScreen(onQuit: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Game Active",
            color = Beige,
            fontSize = 32.sp
        )
    }
}
