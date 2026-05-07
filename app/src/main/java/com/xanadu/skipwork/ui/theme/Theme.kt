package com.xanadu.skipwork.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val SkipWorkColorScheme = darkColorScheme(
    primary = Beige,
    onPrimary = Black,
    secondary = LightGray,
    onSecondary = Beige,
    background = Black,
    onBackground = Beige,
    surface = DarkGray,
    onSurface = Beige,
    error = Red,
    onError = Black
)

@Composable
fun SkipWorkTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = SkipWorkColorScheme,
        typography = SkipWorkTypography,
        content = content
    )
}
