package com.example.gymadmin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gymadmin.Screens.Nav
import com.example.gymadmin.Screens.NewMemberScreen
import com.example.gymadmin.data.Item
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        Log.d("TAG", "FirebaseApp initialized")
        val db = FirebaseFirestore.getInstance()
        val authManager = FirebaseAuthManager()
        enableEdgeToEdge()
        setContent {
           NewMemberScreen()
        }
    }

    companion object{
        var items= listOf(
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023",
                dob="13/11/2003"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023",
                dob="13/11/2003"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023",
                dob="13/11/2003"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023",
                dob="13/11/2003"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023",
                dob="13/11/2003"
            ),
            Item(
                gender = "male",
                name = "Ajeesh Rawal",
                number = 7393085376,
                duration = 3,
                date = "8/9/2023",
                dob="13/11/2003"
            ),
        )
    }

}
