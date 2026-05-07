package com.xanadu.skipwork.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.xanadu.skipwork.R
import com.xanadu.skipwork.ui.theme.Beige
import kotlinx.coroutines.delay

@Composable
fun AppLoadingScreen(onLoadingComplete: () -> Unit) {
    val showLogo = remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        delay(3000) // 3 second loading time
        onLoadingComplete()
    }
    
    LaunchedEffect(Unit) {
        showLogo.value = true
    }
    
    val logoAlpha = animateFloatAsState(
        targetValue = if (showLogo.value) 1f else 0f,
        animationSpec = tween(1000),
        label = "LogoAlpha"
    )
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_office_chair),
            contentDescription = "Skip Work Logo",
            modifier = Modifier
                .alpha(logoAlpha.value)
        )
        Text(
            text = "Loading...",
            color = Beige,
            fontSize = 16.sp,
            modifier = Modifier
                .alpha(logoAlpha.value)
        )
    }
}
