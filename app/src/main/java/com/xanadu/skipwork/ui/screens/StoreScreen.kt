package com.xanadu.skipwork.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xanadu.skipwork.ui.theme.Beige
import com.xanadu.skipwork.ui.components.MenuButton
import com.xanadu.skipwork.ui.components.BackButton

@Composable
fun StoreScreen(
    credits: Int,
    onHome: () -> Unit,
    onContinue: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Optional: Add a BackButton at the top left if you prefer that over a "Home" button
        
        Text(text = "Store", color = Beige, fontSize = 32.sp)
        Text(text = "Credits: $credits", color = Beige, fontSize = 16.sp)
        
        Spacer(modifier = Modifier.height(32.dp))

        MenuButton(text = "Play", onClick = onContinue)
        Spacer(modifier = Modifier.height(16.dp))
        MenuButton(text = "Back to Home", onClick = onHome)
    }
}
