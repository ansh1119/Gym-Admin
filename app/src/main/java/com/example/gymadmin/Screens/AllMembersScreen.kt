package com.example.gymadmin.Screens

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gymadmin.Data.Item
import com.example.gymadmin.MainActivity
import com.example.gymadmin.R
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AllMembersScreen(){
    val InterFamily = FontFamily(
        Font(R.font.inter, FontWeight.Light),

        )
    val PoppinsFamily = FontFamily(
        Font(R.font.poppins, FontWeight.Light),

        )

    val db = FirebaseFirestore.getInstance()
    val usersCollection = db.collection("users")
    val today = LocalDate.now()
    val list by remember{
        mutableStateOf(mutableListOf<Item>())
    }
    val context = LocalContext.current


    usersCollection.get().addOnSuccessListener { documents ->
        Log.d(TAG, "documents accessed")
        for (document in documents.documents) {
            Log.d(TAG,"documents k andar")
            // Convert document to your data class object (see step 6)
            val user = document.toObject(Item::class.java)!! // Replace User with your data class name
            // Use the user object and its member variables
            val joinDate=user.endingDate
            val localDate = LocalDate.parse(joinDate, DateTimeFormatter.ISO_LOCAL_DATE)
            var x=today.isBefore(localDate)

            if(today.isBefore(localDate)){
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


                itemsIndexed(list){ index, item ->
                    ColumnItems(item)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

        }

    }
}

//@Composable
//fun ColumnItems(item: Item){
//    Row(
//        modifier= Modifier
//            .background(color = Color.White)
//            .fillMaxWidth()
//            .height(70.dp)
//            .padding(10.dp)
//    ) {
//        if(item.gender=="male") {
//            Image(
//                painter = painterResource(id = R.drawable.gender_male), contentDescription = "Male",
//                modifier = Modifier
//                    .width(30.dp)
//                    .height(30.dp)
//                    .padding(10.dp)
//            )
//        }
//        else if(item.gender=="female")
//        {
//            Image(
//                painter = painterResource(id = R.drawable.gender_female), contentDescription = "Male",
//                modifier = Modifier
//                    .width(30.dp)
//                    .height(30.dp)
//                    .padding(10.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.width(10.dp))
//
//        Column{
//            Text(text = item.name,style=TextStyle(
//                fontSize=20.sp,
//                fontWeight=FontWeight.SemiBold,
//                fontFamily = PoppinsFamily
//            ))
//            Spacer(modifier = Modifier.height(3.dp))
//
//            Text(text = item.number.toString(),style=TextStyle(
//                fontSize=12.sp,
//                fontFamily = PoppinsFamily
//            ))
//        }
//
//        Spacer(modifier = Modifier.width(110.dp))
//
//        Column(horizontalAlignment = Alignment.End,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.fillMaxHeight()){
//            var duration=item.duration
//            Text(text = "$duration Months",style=TextStyle(
//                fontSize=12.sp,
//                fontFamily = PoppinsFamily
//            ))
//            Spacer(modifier = Modifier.height(3.dp))
//
//            Text(text = item.date,style=TextStyle(
//                fontSize=12.sp,
//                fontFamily = PoppinsFamily
//            ))
//        }
//
//
//    }
//
//}
