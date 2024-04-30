package com.example.gymadmin.FirebaseManager

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.gymadmin.Data.Item
import com.google.firebase.firestore.FirebaseFirestore

class addUserToFirebase {
    val db = FirebaseFirestore.getInstance()

    fun addUser(item: Item, context: Context) {
        val usersCollection = db.collection("users")

        Log.d("addUser", "Adding user: $item") // Log the user data

        usersCollection.add(item)
            .addOnSuccessListener { documentReference ->
                Log.d("addUser", "User added successfully!")
                Toast.makeText(context, "User added successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                Log.e("addUser", "Error adding user: ${exception.message}", exception)
                Toast.makeText(context, "Error adding user!", Toast.LENGTH_SHORT).show()
            }
    }

}