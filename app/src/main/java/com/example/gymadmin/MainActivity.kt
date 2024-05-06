package com.example.gymadmin

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.gymadmin.Data.Item
import com.example.gymadmin.Screens.HomeScreen
import com.example.gymadmin.Screens.NewMemberScreen
import com.google.firebase.FirebaseApp
import java.time.Instant.now
import java.time.LocalDate


class MainActivity : ComponentActivity() {



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)
        setContent {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                HomeScreen()
            }
        }
    }

    companion object{
        @RequiresApi(Build.VERSION_CODES.O)
        var items= listOf(
            Item(
                firstName = "Ajeesh",
                lastName = "Rawal",
                gender = "male",
                duration = 3,
                phone= "7393085376",
                dob= "8/9/2003",
                startingDate = LocalDate.now(),
                endingDate = LocalDate.now().plusMonths(3)
            ),
            Item(
                firstName = "Ajeesh",
                lastName = "Rawal",
                gender = "male",
                duration = 3,
                phone= "7393085376",
                dob= "8/9/2003",
                startingDate = LocalDate.now(),
                endingDate = LocalDate.now().plusMonths(3)
            ),
            Item(
                firstName = "Ajeesh",
                lastName = "Rawal",
                gender = "male",
                duration = 3,
                phone= "7393085376",
                dob= "8/9/2003",
                startingDate = LocalDate.now(),
                endingDate = LocalDate.now().plusMonths(3)
            ),
            Item(
                firstName = "Ajeesh",
                lastName = "Rawal",
                gender = "male",
                duration = 3,
                phone= "7393085376",
                dob= "8/9/2003",
                startingDate = LocalDate.now(),
                endingDate = LocalDate.now().plusMonths(3)
            ),
            Item(
                firstName = "Ajeesh",
                lastName = "Rawal",
                gender = "male",
                duration = 3,
                phone= "7393085376",
                dob= "8/9/2003",
                startingDate = LocalDate.now(),
                endingDate = LocalDate.now().plusMonths(3)
            ),
            Item(
                firstName = "Ajeesh",
                lastName = "Rawal",
                gender = "male",
                duration = 3,
                phone= "7393085376",
                dob= "8/9/2003",
                startingDate = LocalDate.now(),
                endingDate = LocalDate.now().plusMonths(3)
            ),
        )
    }
}
