package com.example.gymadmin

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gymadmin.screens.FirstScreen
import com.example.gymadmin.screens.LoginScreen
import com.example.gymadmin.screens.SignUpScreen
import kotlinx.coroutines.delay

@Composable
fun Nav() {

    val navController=rememberNavController()
    var show by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit){
        delay(1500)
        show = false
    }
    NavHost(navController = navController, startDestination = "first"){
        composable(route="first"){
            if (show){
                FirstScreen(navController)
            }
            else{
                SignUpScreen(navController)
            }
        }
        composable(route="login"){
            LoginScreen(navController)
        }
    }
}