package com.example.gymadmin.Screens

import android.content.Context
import android.os.Build
import android.util.Log
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
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.ui.Modifier
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Calendar
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
import java.time.Instant.now
import android.widget.DatePicker
import java.util.*
import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Alignment
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
    val context= LocalContext
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
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyyy")
                .format(startDate)
        }
    }

    var isExpanded by remember {
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



    var endingDate=startDate.plusMonths(actualDuration.toLong())

Surface(color = Color(0xFFDAD9D4),
    modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
    Column(
        modifier = androidx.compose.ui.Modifier.padding(2.dp)
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
                .padding(20.dp))
        {
            ExposedDropdownMenuBox(expanded = isExpanded,
                modifier = Modifier
                    .fillMaxWidth(0.4f), onExpandedChange = {
                isExpanded = it
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
                    ExposedDropdownMenu(expanded = isExpanded,
                        modifier = Modifier
                            .background(Color(0xffffffff))
                            .fillMaxWidth(0.3f),
                        onDismissRequest = {
                            isExpanded = false
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
                                isExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(text = "Female")
                            },
                            onClick = {
                                gender = "Female"
                                isExpanded = false
                            }
                        )
                    }
                }

            }
            ExposedDropdownMenuBox(expanded = isExpanded,
                modifier=Modifier.fillMaxWidth(0.3f), onExpandedChange = {
                isExpanded = it
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

                Spacer(modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .width(30.dp))

                Box(modifier = Modifier.fillMaxWidth(0.3f)) {
                    ExposedDropdownMenu(expanded = isExpanded,
                        modifier = Modifier
                            .background(Color(0xffffffff))
                            .fillMaxWidth(0.3f),
                        onDismissRequest = {
                            isExpanded = false
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
                                isExpanded = false
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
                                isExpanded = false
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
                                isExpanded = false
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
                                isExpanded = false
                            }
                        )
                    }
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

//        OutlinedTextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 10.dp, end = 10.dp),
//            value = startDate,
//            onValueChange = {
//                var temp =it
//                startDate = temp as LocalDate
//            },
//            placeholder = { Text(text = "Starting Date") },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
//            shape = RoundedCornerShape(10.dp),
//            leadingIcon = {Image(painter = painterResource(id = R.drawable.calendaricon), contentDescription ="logo" ,Modifier.width(20.dp))},
//            colors = OutlinedTextFieldDefaults
//                .colors(
//                    focusedContainerColor = Color(0xffffffff),
//                    unfocusedContainerColor = Color(0xffffffff),
//                    unfocusedBorderColor = Color(0x00ffffff),
//                    focusedBorderColor = Color(0x00ffffff),
//                    focusedPlaceholderColor = Color(0xff636363),
//                    focusedTextColor = Color(0xff000000),
//                    unfocusedTextColor = Color(0xff000000),
//                    unfocusedPlaceholderColor = Color(0xff636363),
//                    focusedLeadingIconColor = Color(0xff636363),
//                    unfocusedLeadingIconColor = Color(0xff636363),
//                ),
//        )








    }

    fun onAddCustomerClick(ob: Item, context: Context) {


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
}
}