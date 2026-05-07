package com.xanadu.skipwork.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xanadu.skipwork.ui.theme.Beige
import com.xanadu.skipwork.ui.theme.LightGray

@Composable
fun BackButton(onClick: () -> Unit) {
    // Making it a fixed width so it doesn't take up the whole top bar
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(80.dp) 
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = LightGray,
            contentColor = Beige
        )
    ) {
        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
    }
}

@Composable
fun MenuButton(
    text: String,
    onClick: () -> Unit,
    isIcon: Boolean = false // Add this line back
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
        // You can use isIcon here later to add an Icon() next to the Text()
        Text(text = text, fontSize = 14.sp)
    }
}
