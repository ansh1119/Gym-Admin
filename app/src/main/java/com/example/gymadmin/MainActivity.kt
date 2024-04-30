package com.example.gymadmin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gymadmin.Screens.Nav
import com.example.gymadmin.Screens.NewMemberScreen
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
}
