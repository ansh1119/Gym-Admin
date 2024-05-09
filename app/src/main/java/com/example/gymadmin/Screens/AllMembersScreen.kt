package com.example.gymadmin.Screens

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymadmin.Components.ColumnItems
import com.example.gymadmin.Data.Item
import com.example.gymadmin.MainActivity
import com.example.gymadmin.R
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllMembersScreen(){
    val PoppinsFamily = FontFamily(
        Font(R.font.poppins, FontWeight.Light),

        )


    val db = FirebaseFirestore.getInstance()
    val usersCollection = db.collection("users")
    val today = LocalDate.now()
    val list = (mutableListOf<Item>())
    val context = LocalContext.current


    usersCollection.get().addOnSuccessListener { documents ->
        Log.d(TAG, "documents accessed")
        for (document in documents.documents) {
            Log.d(TAG,"documents k andar")
            // Convert document to your data class object (see step 6)
            val user = document.toObject(Item::class.java)!! // Replace User with your data class name
            // Use the user object and its member variables
            val joinDate=user.endingDate
            val formattedJoinDate = LocalDate.parse(joinDate, DateTimeFormatter.ISO_LOCAL_DATE)

            if(today.isBefore(formattedJoinDate)){
                list.add(user)
            }
        }
    }.addOnFailureListener { exception ->
        Toast.makeText(context,"no users",Toast.LENGTH_SHORT).show()
    }



    Surface(color = Color(0xFFDAD9D4),
        modifier = Modifier.
        fillMaxSize()){
        Column(modifier = Modifier.
        padding(2.dp)) {
            Image(painter = painterResource(id = R.drawable.logo) , contentDescription = "logo",
                Modifier
                    .fillMaxWidth(0.4f)
                    .padding(start = 10.dp)
                    .height(60.dp)
            )

            Divider(color=Color(0xFFC6C6C6), thickness = 2.dp,
                modifier=Modifier.padding(start=10.dp, end = 10.dp))

            Spacer(Modifier.height(10.dp))

            Text(text ="All Members",
                modifier=Modifier.padding(start=10.dp),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = PoppinsFamily
                )
            )
            LazyColumn(
                modifier=Modifier.fillMaxSize()
                    .padding(10.dp),
                contentPadding= PaddingValues(10.dp),
            ){


                itemsIndexed(MainActivity.items){ _, item ->
                    ColumnItems(item)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}
