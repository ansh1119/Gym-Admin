package com.example.gymadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity() {

    companion object{
        var items= listOf(
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023"
            ),
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nav()
        }
    }
}
