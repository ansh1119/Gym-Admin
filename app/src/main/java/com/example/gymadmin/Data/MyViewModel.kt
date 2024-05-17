package com.example.gymadmin.Data

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gymadmin.Data.Item
import com.google.firebase.firestore.FirebaseFirestore

class MyViewModel : ViewModel() {

    private val firestore= FirebaseFirestore.getInstance()

    val itemList: MutableState<List<Item>> = mutableStateOf(emptyList())

    init {
        fetchItems()
    }
    private fun fetchItems(){
        firestore.collection("users")
            .get()
            .addOnSuccessListener {documents->
                val items = mutableListOf<Item>()
                for (document in documents){
                    val data =document.data
                    val item=Item(
                        data["firstName"] as String,
                        data["lastName"] as String,
                        data["gender"] as String,
                        data["duration"] as Long,
                        data["phone"] as String,
                        data["dob"] as String,
                        data["startingDate"] as String,
                        data["endingDate"] as String
                    )
                    items.add(item)
                }
                itemList.value=items
            }
            .addOnFailureListener{ exception->
                Log.e("Firestore", "Error fetching items",exception)
            }
    }
}