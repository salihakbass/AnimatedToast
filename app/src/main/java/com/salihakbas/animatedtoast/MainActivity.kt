package com.salihakbas.animatedtoast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.salihakbas.animatedtoast.ui.AnimatedToastHost
import com.salihakbas.animatedtoast.ui.theme.AnimatedToastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedToastTheme {
               Surface(modifier = Modifier.fillMaxSize()) {
                   TestToastScreen()
               }
           }
        }
    }
}

@Composable
fun TestToastScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                AnimatedToast.showSuccess("Başarılı işlem!")
            }) {
                Text("Show Success Toast")
            }

            Button(onClick = {
                AnimatedToast.showError("Hata oluştu!")
            }) {
                Text("Show Error Toast")
            }

            Button(onClick = {
                AnimatedToast.showInfo("Bilgilendirme")
            }) {
                Text("Show Info Toast")
            }
        }

        AnimatedToastHost()
    }
}