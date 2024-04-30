package com.example.gymadmin.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gymadmin.R

@Composable
fun HomeScreen(navController: NavHostController) {

    var date:String
    
    Surface(onClick = { /*TODO*/ }) {
        Column {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
            Row {
                Text(text = "Welcome,",
                    color = Color(0xFF787879),
                    fontSize = 24.sp)
                Text(text = " Admin!",
                    color = Color(0xFF313131),
                    fontSize = 24.sp)
            }
            Divider()
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier= Modifier
                .fillMaxWidth()
                .fillMaxHeight(.2f),
                horizontalArrangement = Arrangement.Center){
                Card(modifier= Modifier
                    .fillMaxWidth(.4f)
                    .fillMaxHeight(1f)
                    .clickable {

                    }) {
                    Column(modifier=Modifier
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Status",
                            color = Color(0xFF70706E),
                            fontSize = 16.sp)
                        var checked by remember{
                            mutableStateOf(true)
                        }
                        Switch(modifier= Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .size(60.dp),
                            checked = checked, onCheckedChange ={checked=it} )
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)) {
                Card(modifier= Modifier
                    .weight(.3f)
                    .clickable {
                        navController.navigate(route = "due")
                    }) {
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Due Today")
                    }

                    Row(modifier=Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Image(modifier= Modifier
                            .size(60.dp)
                            .weight(.3f),
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "person")
                        Text(modifier=Modifier.weight(.2f),
                            text = "10",
                            fontSize = 32.sp)
                        Image(painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                            contentDescription = "arrow")
                    }
                }
                Spacer(modifier = Modifier.weight(.1f))
                Card(modifier=Modifier.weight(.3f)) {
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Due Today")
                    }

                    Row(modifier=Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Image(modifier= Modifier
                            .size(60.dp)
                            .weight(.3f),
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "person")
                        Text(modifier=Modifier.weight(.2f),
                            text = "10",
                            fontSize = 32.sp)
                        Image(painter = painterResource(id = R.drawable.baseline_navigate_next_24), contentDescription = "arrow")
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)) {
                Card(modifier=Modifier.weight(.3f)) {
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Due Today")
                    }

                    Row(modifier=Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Image(modifier= Modifier
                            .size(60.dp)
                            .weight(.3f),
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "person")
                        Text(modifier=Modifier.weight(.2f),
                            text = "10",
                            fontSize = 32.sp)
                        Image(painter = painterResource(id = R.drawable.baseline_navigate_next_24), contentDescription = "arrow")
                    }
                }


                Spacer(modifier = Modifier.weight(.1f))


                Card(modifier=Modifier.weight(.3f)) {
                    Row(modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Due Today")
                    }

                    Row(modifier=Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Image(modifier= Modifier
                            .size(60.dp)
                            .weight(.3f),
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "person")
                        Text(modifier=Modifier.weight(.2f),
                            text = "10",
                            fontSize = 32.sp)
                        Image(painter = painterResource(id = R.drawable.baseline_navigate_next_24), contentDescription = "arrow")
                    }
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
                    .weight(.8f)
                    .clip(RoundedCornerShape(40.dp)),
                    value = text, onValueChange ={
                    text=it
                } )
                Button(modifier=Modifier.clip(RoundedCornerShape(140.dp)),
                    shape = CircleShape,
                onClick = { /*TODO*/ }) {
                    Text(text = "Send")
                }
            }
            Row {
                //Navbar
                Button(onClick = { /*TODO*/ }) {
                    
                }
            }
        }
        
    }
}