package com.example.gymadmin.Screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gymadmin.Data.Item
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.reflect.Modifier
import java.time.Instant.now
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NewMemberScreen() {
    val context= LocalContext
    var first by remember {
        mutableStateOf("")
    }
    var last by remember{
        mutableStateOf("")
    }
    var gender by remember{
        mutableStateOf("M")
    }
    var duration by remember{
        mutableStateOf("3 Months")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var dob by remember{
        mutableStateOf("")
    }
    var startDate by remember{
        mutableStateOf(LocalDate.now())
    }


    var actualDuration=0
    if(duration.equals("1 Month")){
        actualDuration=1
    }
    if(duration.equals("3 Months")){
        actualDuration=3
    }
    if(duration.equals("6 Months")){
        actualDuration=6
    }
    if(duration.equals("12 Months")){
        actualDuration=12
    }

    var endingDate=startDate.plusMonths(actualDuration.toLong())

Surface() {


    }
}

fun onAddCustomerClick(ob: Item,context:Context) {


    // Add customer data to Firestore
    val db = FirebaseFirestore.getInstance()
    val customerRef = db.collection("users").document(ob.phone)
    customerRef.set(ob)
        .addOnSuccessListener {
           Toast.makeText(context,"Member added successfully", Toast.LENGTH_SHORT).show()
        }
        .addOnFailureListener { exception ->
            Toast.makeText(context,"error in databse, try again", Toast.LENGTH_SHORT).show()
        }
}