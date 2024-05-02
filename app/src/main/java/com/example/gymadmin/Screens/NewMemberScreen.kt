package com.example.gymadmin.Screens

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymadmin.Data.Item
import com.example.gymadmin.R
import com.google.firebase.firestore.FirebaseFirestore
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.derivedStateOf
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NewMemberScreen() {
    val InterFamily = FontFamily(
        Font(R.font.inter, FontWeight.Light),

        )
    val PoppinsFamily = FontFamily(
        Font(R.font.poppins, FontWeight.Light),

        )
    val context= LocalContext.current

    val startCalendarState= rememberSheetState()
    val endCalendarState= rememberSheetState()


    var first by remember {
        mutableStateOf("")
    }
    var last by remember{
        mutableStateOf("")
    }
    var gender by remember{
        mutableStateOf("Gender")
    }
    var duration by remember{
        mutableStateOf("Duration")
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
    var endingDate by remember{
        mutableStateOf(LocalDate.now())
    }

    val startFormattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd MMM yyyy")
                .format(startDate)
        }
    }

    var isExpandedGender by remember {
        mutableStateOf(false)
    }
    var isExpandedDuration by remember {
        mutableStateOf(false)
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
    else{
        actualDuration=0;
    }

    val endFormattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd MMM yyyy")
                .format(endingDate)
        }
    }

Surface(color = Color(0xFFDAD9D4),
    modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
    ) {
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

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "New here? Join in!",
            modifier = Modifier.padding(start = 10.dp),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = PoppinsFamily
            )
        )

       Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = first,
            onValueChange = {
                first = it
            },
            placeholder = { Text(text = "First Name") },
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {Image(painter = painterResource(id = R.drawable.textfeildone), contentDescription ="logo" ,Modifier.width(20.dp))},
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedContainerColor = Color(0xffffffff),
                    unfocusedContainerColor = Color(0xffffffff),
                    unfocusedBorderColor = Color(0x00ffffff),
                    focusedBorderColor = Color(0x00ffffff),
                    focusedPlaceholderColor = Color(0xff636363),
                    focusedTextColor = Color(0xff000000),
                    unfocusedTextColor = Color(0xff000000),
                    unfocusedPlaceholderColor = Color(0xff636363),
                    focusedLeadingIconColor = Color(0xff636363),
                    unfocusedLeadingIconColor = Color(0xff636363),
            ),
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = last,
            onValueChange = {
                last = it
            },
            placeholder = { Text(text = "Last Name") },
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {Image(painter = painterResource(id = R.drawable.textfeildone), contentDescription ="logo" ,Modifier.width(20.dp))},
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedContainerColor = Color(0xffffffff),
                    unfocusedContainerColor = Color(0xffffffff),
                    unfocusedBorderColor = Color(0x00ffffff),
                    focusedBorderColor = Color(0x00ffffff),
                    focusedPlaceholderColor = Color(0xff636363),
                    focusedTextColor = Color(0xff000000),
                    unfocusedTextColor = Color(0xff000000),
                    unfocusedPlaceholderColor = Color(0xff636363),
                    focusedLeadingIconColor = Color(0xff636363),
                    unfocusedLeadingIconColor = Color(0xff636363),
                ),
        )

        Spacer(modifier = Modifier.height(20.dp))


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp))
        {
            ExposedDropdownMenuBox(expanded = isExpandedGender,
                modifier = Modifier
                    .weight(0.4f), onExpandedChange = {
                isExpandedGender = it
            }
            )
            {
                OutlinedTextField(
                    value = gender,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.dropdown),
                            contentDescription = "dropdown",
                            modifier = Modifier
                                .height(20.dp)
                        )
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedContainerColor = Color(0xffffffff),
                            unfocusedContainerColor = Color(0xffffffff),
                            unfocusedBorderColor = Color(0x00ffffff),
                            focusedBorderColor = Color(0x00ffffff),
                            focusedPlaceholderColor = Color(0xff636363),
                            focusedTextColor = Color(0xff000000),
                            unfocusedTextColor = Color(0xff000000),
                            unfocusedPlaceholderColor = Color(0xff636363),
                            focusedLeadingIconColor = Color(0xff636363),
                            unfocusedLeadingIconColor = Color(0xff636363),
                        ),
                    modifier = Modifier.menuAnchor()
                )


                Box(modifier = Modifier.fillMaxWidth(0.3f)) {
                    ExposedDropdownMenu(expanded = isExpandedGender,
                        modifier = Modifier
                            .background(Color(0xffffffff))
                            .fillMaxWidth(0.3f),
                        onDismissRequest = {
                            isExpandedGender = false
                        }
                    )
                    {
                        DropdownMenuItem(
                            modifier = Modifier
                                .background(Color(0xffffffff)),
                            text = {
                                Text(text = "Male")
                            },
                            onClick = {
                                gender = "Male"
                                isExpandedGender = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(text = "Female")
                            },
                            onClick = {
                                gender = "Female"
                                isExpandedGender = false
                            }
                        )
                    }
                }

            }


                Spacer(modifier = Modifier
                    .weight(.1f))



            ExposedDropdownMenuBox(
                expanded = isExpandedDuration,
                modifier=Modifier.weight(0.4f), onExpandedChange = {
                    isExpandedDuration = it
                }
            )
            {
                OutlinedTextField(
                    value = duration,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.dropdown),
                            contentDescription = "dropdown",
                            modifier = Modifier
                                .height(20.dp)
                        )
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedContainerColor = Color(0xffffffff),
                            unfocusedContainerColor = Color(0xffffffff),
                            unfocusedBorderColor = Color(0x00ffffff),
                            focusedBorderColor = Color(0x00ffffff),
                            focusedPlaceholderColor = Color(0xff636363),
                            focusedTextColor = Color(0xff000000),
                            unfocusedTextColor = Color(0xff000000),
                            unfocusedPlaceholderColor = Color(0xff636363),
                            focusedLeadingIconColor = Color(0xff636363),
                            unfocusedLeadingIconColor = Color(0xff636363),
                        ),
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(expanded = isExpandedDuration,
                    modifier = Modifier
                        .background(Color(0xffffffff))
                        .fillMaxWidth(0.3f),
                    onDismissRequest = {
                        isExpandedDuration = false
                    }
                )
                {
                    DropdownMenuItem(
                        modifier = Modifier
                            .background(Color(0xffffffff)),
                        text = {
                            Text(text = "1 Month")
                        },
                        onClick = {
                            duration = "1 Month"
                            isExpandedDuration = false
                        }
                    )
                    DropdownMenuItem(
                        modifier = Modifier
                            .background(Color(0xffffffff)),
                        text = {
                            Text(text = "3 Months")
                        },
                        onClick = {
                            duration = "3 Months"
                            isExpandedDuration = false
                        }
                    )
                    DropdownMenuItem(
                        modifier = Modifier
                            .background(Color(0xffffffff)),
                        text = {
                            Text(text = "6 Months")
                        },
                        onClick = {
                            duration = "6 Months"
                            isExpandedDuration = false
                        }
                    )
                    DropdownMenuItem(
                        modifier = Modifier
                            .background(Color(0xffffffff)),
                        text = {
                            Text(text = "12 Months")
                        },
                        onClick = {
                            duration = "12 Months"
                            isExpandedDuration = false
                        }
                    )
                }
            }


            }



        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = phone,
            onValueChange = {
                phone = it
            },
            placeholder = { Text(text = "Phone Number") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {Image(painter = painterResource(id = R.drawable.textfeildone), contentDescription ="logo" ,Modifier.width(20.dp))},
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedContainerColor = Color(0xffffffff),
                    unfocusedContainerColor = Color(0xffffffff),
                    unfocusedBorderColor = Color(0x00ffffff),
                    focusedBorderColor = Color(0x00ffffff),
                    focusedPlaceholderColor = Color(0xff636363),
                    focusedTextColor = Color(0xff000000),
                    unfocusedTextColor = Color(0xff000000),
                    unfocusedPlaceholderColor = Color(0xff636363),
                    focusedLeadingIconColor = Color(0xff636363),
                    unfocusedLeadingIconColor = Color(0xff636363),
                ),
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = dob,
            onValueChange = {
                dob = it
            },
            placeholder = { Text(text = "DoB") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {Image(painter = painterResource(id = R.drawable.calendaricon), contentDescription ="logo" ,Modifier.width(20.dp))},
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedContainerColor = Color(0xffffffff),
                    unfocusedContainerColor = Color(0xffffffff),
                    unfocusedBorderColor = Color(0x00ffffff),
                    focusedBorderColor = Color(0x00ffffff),
                    focusedPlaceholderColor = Color(0xff636363),
                    focusedTextColor = Color(0xff000000),
                    unfocusedTextColor = Color(0xff000000),
                    unfocusedPlaceholderColor = Color(0xff636363),
                    focusedLeadingIconColor = Color(0xff636363),
                    unfocusedLeadingIconColor = Color(0xff636363),
                ),
        )
        Spacer(modifier = Modifier.height(20.dp))


        CalendarDialog(state = startCalendarState,
            config= CalendarConfig(
                monthSelection = true,
                yearSelection = true
            ),
            selection =CalendarSelection.Date{
                date->
            startDate=date
        } )

        Button(modifier= Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
            colors=ButtonDefaults
                .buttonColors(Color.White),
            onClick = { startCalendarState.show() } ){
            Text(
                text = "Start Date = ${startFormattedDate}",
                color = Color.Black
            )
        }

        CalendarDialog(state = endCalendarState,
            config= CalendarConfig(
                monthSelection = true,
                yearSelection = true
            ),
            selection =CalendarSelection.Date{
                    date->
                endingDate=date
            } )


        Button(modifier= Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
            colors=ButtonDefaults
                .buttonColors(Color.White),
            onClick = { endCalendarState.show() } ){
            Text(
                text = "End Date = ${endFormattedDate}",
                color = Color.Black
            )
        }

        var item=Item(first,last,gender,actualDuration.toLong(),phone,dob, startDate, endingDate)

        Button(onClick = { onAddCustomerClick(item,context) }) {
            Text(text = "Submit")
        }



    }
}
}

fun onAddCustomerClick(ob: Item, context:Context) {


    // Add customer data to Firestore
    val db = FirebaseFirestore.getInstance()
    val customerRef = db.collection("users").document(ob.phone)
    customerRef.set(ob)
        .addOnSuccessListener {
            Toast.makeText(context, "Member added successfully", Toast.LENGTH_SHORT).show()
        }
        .addOnFailureListener { exception ->
            Toast.makeText(context, "error in databse, try again", Toast.LENGTH_SHORT).show()
        }
}