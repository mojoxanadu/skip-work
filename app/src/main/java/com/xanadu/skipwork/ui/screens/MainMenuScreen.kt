package com.xanadu.skipwork.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xanadu.skipwork.R
import com.xanadu.skipwork.ui.theme.Beige
import com.xanadu.skipwork.ui.theme.Black
import com.xanadu.skipwork.ui.theme.LightGray

@Composable
fun MainMenuScreen(
    credits: Int,
    hasProgress: Boolean,
    onPlay: () -> Unit,
    onStartOver: () -> Unit,
    onHelp: () -> Unit,
    onCredits: () -> Unit,
    onSettings: () -> Unit,
    onStore: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left side - Logo
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_office_chair),
                contentDescription = "Skip Work Logo",
                modifier = Modifier.size(150.dp)
            )
        }

        // Right side - Buttons
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(32.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            content = {
                MenuButton(
                    text = if (hasProgress) "Continue" else "Play",
                    onClick = onPlay
                )
                Spacer(modifier = Modifier.height(16.dp))
                MenuButton(text = "Start Over", onClick = onStartOver)
                Spacer(modifier = Modifier.height(16.dp))
                MenuButton(text = "Help", onClick = onHelp, isIcon = true)
                Spacer(modifier = Modifier.height(16.dp))
                MenuButton(text = "Credits", onClick = onCredits)
                Spacer(modifier = Modifier.height(16.dp))
                MenuButton(text = "Settings", onClick = onSettings, isIcon = true)
                Spacer(modifier = Modifier.height(16.dp))
                CreditButton(credits = credits, onClick = onStore)
            }
        )
    }
}

@Composable
fun MenuButton(
    text: String,
    onClick: () -> Unit,
    isIcon: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = LightGray,
            contentColor = Beige
        )
    ) {
        Text(text = text, fontSize = 14.sp)
    }
}

@Composable
fun CreditButton(
    credits: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = LightGray,
            contentColor = Beige
        )
    ) {
        Text(text = "💰 $credits", fontSize = 14.sp)
    }
}
