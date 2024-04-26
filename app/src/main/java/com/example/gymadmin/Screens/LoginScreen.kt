package com.example.gymadmin.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
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
import androidx.compose.ui.draw.scale
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
import com.example.gymadmin.R



@Composable
fun LoginScreen(navController: NavHostController) {
    val InterFamily = FontFamily(
        Font(R.font.inter, FontWeight.Light),
    )

    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val user="admin"
    val pass="admin123"

    val context=LocalContext.current

    Surface {
        Box(modifier=Modifier.fillMaxSize()) {
            Image(modifier= Modifier
                .fillMaxSize()
                .scale(1.05f),
                painter = painterResource(id = R.drawable.login),
                contentDescription = "background")
            Column(modifier= Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,) {

                Row (modifier= Modifier
                    .fillMaxWidth(.8f)
                    .padding(top = 40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){
                    Image(modifier=Modifier.scale(1f),
                        painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
                }



                Row (modifier= Modifier
                    .fillMaxWidth(.8f)
                    .padding(top = 50.dp),
                    horizontalArrangement = Arrangement.Start){
                    Text(text = "Sign Up",
                        color = Color(0xFFE41B1B),
                        fontFamily = InterFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                }


                Row (modifier=Modifier.fillMaxWidth(.8f),
                    horizontalArrangement = Arrangement.Start){
                    Text(text = "with your Admin\ncredentials",
                        color = Color(0xFF313131),
                        fontFamily = InterFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.padding(top=40.dp))


                Card(modifier = Modifier
                    .fillMaxHeight(.7f)
                    .fillMaxWidth(.8f)
                    .padding(10.dp),
                    colors = CardDefaults.cardColors(Color(0xff131313))) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Row (modifier=Modifier.fillMaxWidth(.9f),
                            horizontalArrangement = Arrangement.Start){
                            Text(modifier=Modifier.padding(top=20.dp),
                                text = "Username",
                                color = Color.White,
                                fontWeight=FontWeight.Bold,
                                fontSize = 16.sp)
                        }

                        TextField(modifier= Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(.8f)
                            .fillMaxHeight(.18f)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFFC6C6C6)),
                            value = name,
                            onValueChange = {name=it},
                            textStyle = TextStyle(color = Color.Black)
                        )


                        Row (modifier=Modifier.fillMaxWidth(.9f),
                            horizontalArrangement = Arrangement.Start) {
                            Text(
                                modifier = Modifier.padding(top = 30.dp),
                                text = "Password",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }

                        TextField(modifier= Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(.8f)
                            .fillMaxHeight(.3f)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFFC6C6C6)),
                            value = password,
                            onValueChange = {password=it})


                        Row(modifier= Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth(0.8f),
                            horizontalArrangement = Arrangement.End) {
                            Text(text = "Forgot Password?",
                                color = Color.White,
                                fontWeight=FontWeight.Bold,
                                fontSize = 12.sp)
                        }


                        Divider(Modifier.padding(start=10.dp, end = 10.dp,top=30.dp))


                        Button(modifier= Modifier
                            .fillMaxWidth(.8f)
                            .padding(top = 20.dp)
                            .border(1.dp, Color(0xFFFFFFFF), RoundedCornerShape(6.dp)),
                            shape = RoundedCornerShape(5.dp),
                            onClick = {
                                    if(name==user && password==pass){
                                        navController.navigate("home")
                                        Toast.makeText(context,"Signed Up, Login Now",Toast.LENGTH_LONG).show()
                                    }
                                    else{
                                        Toast.makeText(context,"couldnt login, try again",Toast.LENGTH_LONG).show()
                                    }
                                 },
                            colors=ButtonDefaults.buttonColors(Color(0xFFBF4846))) {
                            Text(
                                text = "Login",
                                fontFamily = InterFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }

        }
    }
}