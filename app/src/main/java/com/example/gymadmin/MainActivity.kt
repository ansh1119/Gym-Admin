package com.example.gymadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gymadmin.Data.Item
import com.example.gymadmin.Screens.AddMember
import com.google.firebase.FirebaseApp
import java.time.Instant.now
import java.time.LocalDate


class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)
        setContent {
            AddMember()
        }
    }

    companion object{
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
