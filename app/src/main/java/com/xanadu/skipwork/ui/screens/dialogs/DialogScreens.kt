package com.xanadu.skipwork.ui.screens.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.xanadu.skipwork.ui.theme.Beige
import com.xanadu.skipwork.ui.theme.Black
import com.xanadu.skipwork.ui.theme.DarkGray
import com.xanadu.skipwork.ui.theme.LightGray

@Composable
fun StartOverConfirmDialog(
    onCancel: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(dismissOnBackPress = false)
    ) {
        Column(
            modifier = Modifier
                .background(DarkGray, RoundedCornerShape(16.dp))
                .padding(24.dp)
                .width(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Are you sure you want to start over from the ground floor?",
                color = Beige,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "All your progress will be lost. (You keep your credits though.)",
                color = Beige,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onCancel,
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightGray,
                        contentColor = Beige
                    )
                ) {
                    Text("Cancel", fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onConfirm,
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightGray,
                        contentColor = Beige
                    )
                ) {
                    Text("Start Over", fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun LostLifeDialog(onOk: () -> Unit) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(dismissOnBackPress = false)
    ) {
        Column(
            modifier = Modifier
                .background(DarkGray, RoundedCornerShape(16.dp))
                .padding(24.dp)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Aww!",
                color = Beige,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onOk,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGray,
                    contentColor = Beige
                )
            ) {
                Text("OK", fontSize = 14.sp)
            }
        }
    }
}
