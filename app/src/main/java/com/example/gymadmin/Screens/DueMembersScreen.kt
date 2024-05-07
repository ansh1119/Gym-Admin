package com.example.gymadmin.Screens

import android.os.Build
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
import androidx.compose.ui.Alignment
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
import androidx.navigation.NavController
import com.example.gymadmin.Data.Item
import com.example.gymadmin.MainActivity
import com.example.gymadmin.R


val InterFamily = FontFamily(
    Font(R.font.inter, FontWeight.Light),

    )
val PoppinsFamily = FontFamily(
    Font(R.font.poppins, FontWeight.Light),

    )



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DueMemberScreen(navController: NavController,time:String){
    val context = LocalContext.current
    val date=time
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

            Text(text ="Membership Ending \n$date",
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


                itemsIndexed(MainActivity.items){ index, item ->
                    ColumnItems(item)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            }

        }
    }

@Composable
fun ColumnItems(item: Item){
    Row(
        modifier= Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(70.dp)
            .padding(10.dp)
    ) {
if(item.gender=="male") {
    Image(
        painter = painterResource(id = R.drawable.gender_male), contentDescription = "Male",
        modifier = Modifier
            .width(30.dp)
            .height(30.dp)
            .padding(10.dp)
    )
}
        else if(item.gender=="female")
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
            Text(text = item.firstName!!,style=TextStyle(
                fontSize=20.sp,
                fontWeight=FontWeight.SemiBold,
            ))
            Spacer(modifier = Modifier.height(3.dp))

            Text(text = item.phone.toString(),style=TextStyle(
                fontSize=12.sp,
            ))
        }

        Spacer(modifier = Modifier.width(110.dp))
        
        Column(horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()){
            var duration=item.duration
            Text(text = "$duration Months",style=TextStyle(
                fontSize=12.sp,
            ))
            Spacer(modifier = Modifier.height(3.dp))

            Text(text = item.startingDate.toString(),style=TextStyle(
                fontSize=12.sp,
            ))
        }


    }

}
