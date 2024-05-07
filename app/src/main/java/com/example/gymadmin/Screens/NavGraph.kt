package com.example.gymadmin.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.O)
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
                LoginScreen(navController)
            }
        }
        composable(route="home"){
            HomeScreen(/*navController*/)
        }
        composable(route="due"){
//            DueMemberScreen(navController = navController, time ="" )
        }
    }
}