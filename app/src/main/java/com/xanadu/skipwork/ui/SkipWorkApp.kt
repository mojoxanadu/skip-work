package com.xanadu.skipwork.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.xanadu.skipwork.AppState
import com.xanadu.skipwork.ui.screens.AppLoadingScreen
import com.xanadu.skipwork.ui.screens.MainMenuScreen
import com.xanadu.skipwork.ui.screens.HelpScreen
import com.xanadu.skipwork.ui.screens.CreditsScreen
import com.xanadu.skipwork.ui.screens.SettingsScreen
import com.xanadu.skipwork.ui.screens.FloorLoadingScreen
import com.xanadu.skipwork.ui.screens.GameActiveScreen
import com.xanadu.skipwork.ui.screens.StoreScreen
import com.xanadu.skipwork.ui.screens.dialogs.StartOverConfirmDialog
import com.xanadu.skipwork.ui.screens.dialogs.LostLifeDialog
import com.xanadu.skipwork.ui.theme.Black
import com.xanadu.skipwork.ui.theme.SkipWorkTheme

@Composable
fun SkipWorkApp() {
    SkipWorkTheme {
        val appState = remember { mutableStateOf(AppState.APP_LOADING) }
        val playerCredits = remember { mutableStateOf(0) }
        val hasProgress = remember { mutableStateOf(false) }
        val showDialog = remember { mutableStateOf<DialogType?>(null) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Black)
        ) {
            AnimatedContent(
                targetState = appState.value,
                transitionSpec = {
                    val transition = getTransition(initialState, targetState)
                    transition.enterTransition togetherWith transition.exitTransition
                },
                label = "AppStateTransition"
            ) { state ->
                when (state) {
                    AppState.APP_LOADING -> AppLoadingScreen {
                        appState.value = AppState.MAIN_MENU
                    }
                    AppState.MAIN_MENU -> MainMenuScreen(
                        credits = playerCredits.value,
                        hasProgress = hasProgress.value,
                        onPlay = { appState.value = AppState.FLOOR_LOADING },
                        onStartOver = { showDialog.value = DialogType.START_OVER_CONFIRM },
                        onHelp = { appState.value = AppState.HELP },
                        onCredits = { appState.value = AppState.CREDITS },
                        onSettings = { appState.value = AppState.SETTINGS },
                        onStore = { appState.value = AppState.STORE }
                    )
                    AppState.START_OVER_CONFIRM -> Unit // Handled as dialog
                    AppState.HELP -> HelpScreen {
                        appState.value = AppState.MAIN_MENU
                    }
                    AppState.CREDITS -> CreditsScreen {
                        appState.value = AppState.MAIN_MENU
                    }
                    AppState.SETTINGS -> SettingsScreen {
                        appState.value = AppState.MAIN_MENU
                    }
                    AppState.FLOOR_LOADING -> FloorLoadingScreen {
                        appState.value = AppState.GAME_ACTIVE
                    }
                    AppState.GAME_ACTIVE -> GameActiveScreen(
                        onQuit = { showDialog.value = DialogType.LOST_LIFE }
                    )
                    AppState.LOST_LIFE -> Unit // Handled as dialog
                    AppState.STORE -> StoreScreen(
                        credits = playerCredits.value,
                        onHome = { appState.value = AppState.MAIN_MENU },
                        onContinue = { appState.value = AppState.FLOOR_LOADING }
                    )
                }
            }

            // Dialog Layer
            when (showDialog.value) {
                DialogType.START_OVER_CONFIRM -> StartOverConfirmDialog(
                    onCancel = { showDialog.value = null },
                    onConfirm = {
                        showDialog.value = null
                        appState.value = AppState.FLOOR_LOADING
                        hasProgress.value = false
                    }
                )
                DialogType.LOST_LIFE -> LostLifeDialog(
                    onOk = {
                        showDialog.value = null
                        appState.value = AppState.STORE
                    }
                )
                null -> Unit
            }
        }
    }
}

private fun getTransition(from: AppState, to: AppState): TransitionSpec {
    return when {
        // Loading to Main Menu - fade in
        from == AppState.APP_LOADING && to == AppState.MAIN_MENU -> TransitionSpec(
            enterTransition = fadeIn(),
            exitTransition = fadeOut()
        )
        // Main Menu to navigation screens - slide left
        from == AppState.MAIN_MENU && to in listOf(
            AppState.HELP, AppState.CREDITS, AppState.SETTINGS, 
            AppState.STORE, AppState.FLOOR_LOADING
        ) -> TransitionSpec(
            enterTransition = slideInHorizontally { it },
            exitTransition = slideOutHorizontally { -it }
        )
        // Navigation screens back to Main Menu - slide right
        from in listOf(AppState.HELP, AppState.CREDITS, AppState.SETTINGS) && 
        to == AppState.MAIN_MENU -> TransitionSpec(
            enterTransition = slideInHorizontally { -it },
            exitTransition = slideOutHorizontally { it }
        )
        // Floor Loading to Game Active - fade
        from == AppState.FLOOR_LOADING && to == AppState.GAME_ACTIVE -> TransitionSpec(
            enterTransition = fadeIn(),
            exitTransition = fadeOut()
        )
        // Store to Main Menu - slide right
        from == AppState.STORE && to == AppState.MAIN_MENU -> TransitionSpec(
            enterTransition = slideInHorizontally { -it },
            exitTransition = slideOutHorizontally { it }
        )
        // Store to Floor Loading - slide left
        from == AppState.STORE && to == AppState.FLOOR_LOADING -> TransitionSpec(
            enterTransition = slideInHorizontally { it },
            exitTransition = slideOutHorizontally { -it }
        )
        // Default
        else -> TransitionSpec(
            enterTransition = fadeIn(),
            exitTransition = fadeOut()
        )
    }
}

data class TransitionSpec(
    val enterTransition: androidx.compose.animation.EnterTransition,
    val exitTransition: androidx.compose.animation.ExitTransition
)

enum class DialogType {
    START_OVER_CONFIRM,
    LOST_LIFE
}
