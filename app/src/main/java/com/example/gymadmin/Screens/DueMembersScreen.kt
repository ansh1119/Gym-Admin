package com.example.gymadmin.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavHostController
import com.example.gymadmin.Components.ColumnItems
import com.example.gymadmin.Data.MyViewModel
import com.example.gymadmin.R
import java.time.LocalDate


val PoppinsFamily = FontFamily(
    Font(R.font.poppins, FontWeight.Light),

    )




@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DueMemberScreen(time: String, viewModel: MyViewModel, navController: NavHostController){
    val context = LocalContext.current
    val filteredMembers = viewModel.itemList.value.filter { item ->
        val endingDate = LocalDate.parse(item.endingDate)

        when (time) {
            "Today" -> endingDate.isEqual(LocalDate.now())
            "Week" -> endingDate.isBefore(LocalDate.now().plusWeeks(1)) && !endingDate.isBefore(LocalDate.now())
            "Month" -> endingDate.isBefore(LocalDate.now().plusMonths(1)) && !endingDate.isBefore(LocalDate.now().minusWeeks(1))
            "Expired" -> endingDate.isBefore(LocalDate.now())
            else -> false // Handle invalid time values (optional)
        }
    }
    Surface(color = Color(0xFFDAD9D4),
        modifier = Modifier.
                fillMaxSize()){
        Column(modifier = Modifier.
        padding(2.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
                Modifier
                    .fillMaxWidth(0.4f)
                    .padding(start = 10.dp)
                    .height(60.dp)
            )

            Divider(
                color = Color(0xFFC6C6C6), thickness = 2.dp,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )

            Spacer(Modifier.height(10.dp))

            if (time != "Expired")
            {
                Text(
                    text = "Membership Ending \n$time",
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = PoppinsFamily
                    )
                )
            }
            else{
                Text(
                    text = "Membership Expired",
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = PoppinsFamily
                    )
                )
            }

            LazyColumn {
                items(1) { index ->
                    ColumnItems(list=filteredMembers)
                }
            }

            }

        }
    }

