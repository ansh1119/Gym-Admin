package com.example.gymadmin.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gymadmin.Components.CustomSwitch
import com.example.gymadmin.R

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun  HomeScreen(/*navController: NavController*/) {

    var date:String

    
    Surface(color = Color(0xffDAD9D4),
    modifier=Modifier.fillMaxHeight()) {
        Column {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
            Row(
                Modifier.padding(10.dp)
            ) {
                Text(text = "Welcome,",
                    color = Color(0xFF787879),
                    fontFamily = PoppinsFamily,
                    fontSize = 24.sp)
                Text(text = " Admin!",
                    color = Color(0xFF313131),
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
            }
            Divider()
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier= Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
                horizontalArrangement = Arrangement.Center){
                Card(colors = CardDefaults.cardColors(Color(0xffCECECE)), modifier= Modifier
                    .fillMaxWidth(0.6f)
                    .fillMaxHeight(0.7f)
                    ) {
                    Column(modifier=Modifier
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier
                            .height(10.dp))
                        Text(text = "Status",
                            color = Color(0xFF70706E),
                            fontFamily = PoppinsFamily,
                            fontSize = 18.sp)
                        var checked by remember{
                            mutableStateOf(true)
                        }
                        Spacer(modifier = Modifier
                            .height(20.dp))
                        CustomSwitch(
                            height = 50.dp,
                            width = 160.dp,
                            circleButtonPadding = 4.dp,
                            outerBackgroundOnResource = R.drawable.close_switch,
                            outerBackgroundOffResource = R.drawable.open_switch,
                            circleBackgroundOnResource = R.drawable.circle_switch,
                            circleBackgroundOffResource = R.drawable.circle_switch,
                            stateOn = 1,
                            stateOff = 0,
                            initialValue = 0,
                            onCheckedChanged = {}
                        )
                    }
                }
            }

            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)) {
                Card(colors=CardDefaults.cardColors(Color(0xff000000)),
                    modifier= Modifier
                        .weight(.3f)
                        .clickable {
                            //navController.navigate(route = "due")
                        }) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Due Today",
                            fontSize=16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xffffffff),
                            fontFamily = PoppinsFamily)
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(modifier=Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Image(modifier= Modifier
                            .size(60.dp)
                            .weight(.3f),
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "person")
                        Text(modifier=Modifier.weight(.2f),
                            text = "10",
                            fontSize = 32.sp,
                            fontFamily=PoppinsFamily,
                            fontWeight = FontWeight.Bold,
                            color=Color(0xffffffff))
                        Image(painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                            contentDescription = "arrow")
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Spacer(modifier = Modifier.weight(.1f))
                Card(colors=CardDefaults.cardColors(Color(0xff000000)),
                    modifier= Modifier
                        .weight(.3f)
                        .clickable {
                            //navController.navigate(route = "due")
                        }) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Due This Week",
                            fontSize=16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xffffffff),
                            fontFamily = PoppinsFamily)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier=Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Image(modifier= Modifier
                            .size(60.dp)
                            .weight(.3f),
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "person")
                        Text(modifier=Modifier.weight(.2f),
                            text = "10",
                            fontSize = 32.sp,
                            fontFamily=PoppinsFamily,
                            fontWeight = FontWeight.Bold,
                            color=Color(0xffffffff))
                        Image(painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                            contentDescription = "arrow")
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Spacer(modifier = Modifier.width(10.dp))
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)) {
                Card(colors=CardDefaults.cardColors(Color(0xff000000)),
                    modifier= Modifier
                        .weight(.3f)
                        .clickable {
                            //navController.navigate(route = "due")
                        }) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Due This Month",
                            fontSize=16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xffffffff),
                            fontFamily = PoppinsFamily)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier=Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Image(modifier= Modifier
                            .size(60.dp)
                            .weight(.3f),
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "person")
                        Text(modifier=Modifier.weight(.2f),
                            text = "10",
                            fontSize = 32.sp,
                            fontFamily=PoppinsFamily,
                            fontWeight = FontWeight.Bold,
                            color=Color(0xffffffff))
                        Image(painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                            contentDescription = "arrow")
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }


                Spacer(modifier = Modifier.weight(.1f))


                Card(colors=CardDefaults.cardColors(Color(0xffBF4846)),
                    modifier= Modifier
                        .weight(.3f)
                        .clickable {
                            //navController.navigate(route = "due")
                        }) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {

                        Text(text = "Expired",
                            fontSize=16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xffffffff),
                            fontFamily = PoppinsFamily)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier=Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Image(modifier= Modifier
                            .size(60.dp)
                            .weight(.3f),
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "person")
                        Text(modifier=Modifier.weight(.2f),
                            text = "10",
                            fontSize = 32.sp,
                            fontFamily=PoppinsFamily,
                            color=Color(0xffffffff))
                        Image(painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                            contentDescription = "arrow")
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)) {
                var text by remember {
                    mutableStateOf("")
                }
                TextField(modifier= Modifier
                    .weight(.75f)
                    .fillMaxHeight(0.35f)
                    .clip(RoundedCornerShape(16.dp)),
                    colors=TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xff000000),
                        unfocusedContainerColor = Color(0xff000000),
                        focusedIndicatorColor = Color(0xff000000),
                        unfocusedIndicatorColor = Color(0xff000000),
                        focusedTextColor = Color(0xffffffff),
                        unfocusedTextColor=Color(0xffffffff),
                        focusedPlaceholderColor = Color(0xffffffff),
                        unfocusedPlaceholderColor=Color(0xffffffff)),
                    placeholder = {Text(text = "Message For Customers",
                        fontFamily = PoppinsFamily,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        modifier=Modifier.fillMaxWidth()
                        )},
                    value = text, onValueChange ={
                    text=it
                } )
                Spacer(modifier = Modifier.width(5.dp))
                Button(modifier= Modifier
                    .fillMaxHeight(0.35f)
                    .width(IntrinsicSize.Min)
                    .clip(RoundedCornerShape(2.dp)),
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor =Color(0xffBF4846)
                        ),
                onClick = {
                /*TODO*/
                }
                )
                {
                    Text(text = "Send",
                        fontSize = (18.sp),
                        fontFamily=PoppinsFamily,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold)
                }
            }
//            Row {
//                //Navbar
//                Button(onClick = { /*TODO*/ }) {
//
//                }
//            }
        }
        
    }
}


