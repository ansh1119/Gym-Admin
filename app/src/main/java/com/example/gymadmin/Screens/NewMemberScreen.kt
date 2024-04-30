package com.example.gymadmin.Screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gymadmin.data.Item
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.reflect.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NewMemberScreen() {



    val list=listOf("M","F")



Surface() {
    var first by remember {
        mutableStateOf("")
    }
    var last by remember{
        mutableStateOf("")
    }
    var gender by remember{
        mutableStateOf(list.get(0))
    }
    var duration by remember{
        mutableStateOf(0)
    }
    var phone by remember {
        mutableStateOf(0)
    }
    var dob by remember{
        mutableStateOf("")
    }
    var join by remember{
        mutableStateOf("")
    }


        Button(
            onClick = { var ob=Item(gender,first, phone.toLong(),duration,join,dob)
        onAddCustomerClick(ob)
        }) {
            
        }
    }
}

fun onAddCustomerClick(ob: Item) {
    // Add customer data to Firestore
    val db = FirebaseFirestore.getInstance()
    val customerRef = db.collection("customers").document() // Generate a unique document ID
    customerRef.set(ob)
        .addOnSuccessListener {
            Log.d("TAG", "Customer added successfully!")
            // Show success message (optional)
        }
        .addOnFailureListener { exception ->
            Log.w("TAG", "Error adding customer: ", exception)
            // Show error message (optional)
        }
}