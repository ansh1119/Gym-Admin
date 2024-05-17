package com.example.gymadmin.Components

import android.content.ContentValues.TAG
import android.util.Log
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymadmin.Data.Item
import com.example.gymadmin.R

@Composable
fun ColumnItems(list:List<Item>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        list.forEach { item ->
            RowItems(item=item)
        }
    }
}

@Composable
fun RowItems(item:Item){
    Row(
        modifier= Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(70.dp)
            .padding(10.dp)
    ) {
        if(item.gender=="Male") {
            Image(
                painter = painterResource(id = R.drawable.gender_male), contentDescription = "Male",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(10.dp)
            )
        }
        else if(item.gender=="Female")
        {
            Image(
                painter = painterResource(id = R.drawable.gender_female), contentDescription = "Male",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column{
            Text(text = item.firstName!!,style= TextStyle(
                fontSize=20.sp,
                fontWeight= FontWeight.SemiBold,
            )
            )
            Spacer(modifier = Modifier.height(3.dp))

            Text(text = item.phone.toString(),style= TextStyle(
                fontSize=12.sp,
            )
            )
        }

        Spacer(modifier = Modifier.width(110.dp))

        Column(horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()){
            var duration=item.duration
            Text(text = "$duration Months",style= TextStyle(
                fontSize=12.sp,
                )
            )
            Spacer(modifier = Modifier.height(3.dp))

            Text(text = item.startingDate.toString(),style= TextStyle(
                fontSize=12.sp,
                )
            )
        }


    }
    Spacer(modifier = Modifier.height(10.dp))
}
