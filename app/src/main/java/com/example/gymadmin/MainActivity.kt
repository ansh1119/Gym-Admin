package com.example.gymadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gymadmin.Data.Item
import com.google.firebase.FirebaseApp


class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)
        setContent {
            Nav()
        }
    }

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
}
