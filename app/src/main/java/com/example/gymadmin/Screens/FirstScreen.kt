package com.example.gymadmin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gymadmin.R
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun FirstScreen(navController: NavHostController) {

    val PostFamily = FontFamily(
        Font(R.font.postnobillsextrabold),
    )

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()){
            Image(modifier= Modifier
                .fillMaxSize()
                .scale(1.1f),
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "background")
            Column(modifier=Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(modifier= Modifier
                    .weight(0.1f)
                    .scale(1.1f)
                    .padding(start = 40.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo")
                Text(modifier=Modifier.weight(0.8f),
                    textAlign = TextAlign.Center,
                    text = "\"This is one crime scene you want\n to be a part of\"",
                    fontSize = 20.sp,
                    fontFamily = PostFamily,
                    color = Color(0xFFCECECE)
                )
                Row(modifier=Modifier.padding(bottom=50.dp)) {
                    CircularProgressIndicatorWithDelay(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun CircularProgressIndicatorWithDelay(modifier: Modifier) {
    var showProgress by remember { mutableStateOf(true) }

    LaunchedEffect(showProgress) {
        delay(1500) // Delay for 1.5 seconds
        showProgress = false
    }

    if (showProgress) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .fillMaxWidth(),
            color = Color(0xFFED3F40),
            trackColor = Color(0xFFD9D9D9)
        )
    }
}
