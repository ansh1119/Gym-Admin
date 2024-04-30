package com.example.gymadmin.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gymadmin.Data.Item
import com.example.gymadmin.FirebaseManager.addUserToFirebase
import com.example.gymadmin.R
import java.time.LocalDate
import java.time.LocalDate.now


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddMember() {

    var firstName by remember {
        mutableStateOf("ansh")
    }

    var lastName by remember {
        mutableStateOf("singh")
    }

    var gender by remember {
        mutableStateOf("male")
    }

    var phoneNumber by remember {
        mutableStateOf("8467930517")
    }

    var dob by remember {
        mutableStateOf("19/11/2003")
    }

    var startingDate by remember {
        mutableStateOf(now())
    }

    var expiryDate by remember {
        mutableStateOf(now())
    }

    var formDuration by remember {
        mutableStateOf("3 Months")
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var context=LocalContext.current

    Surface {
        Column {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
            Divider()
            Text(text = "New here? Join in!")
            TextField(value = firstName, onValueChange = {firstName=it})
            TextField(value = lastName, onValueChange ={lastName=it} )
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){

                ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
                    isExpanded=it
                }) {
                    TextField(value = gender,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        modifier=Modifier.menuAnchor()
                    )

                    ExposedDropdownMenu(expanded = isExpanded,
                        onDismissRequest = {
                            isExpanded=false
                        }
                    ){
                        DropdownMenuItem(text = {
                            Text(text = "Male") },
                            onClick = { gender="Male"
                                isExpanded=false
                            })
                        DropdownMenuItem(text = {
                            Text(text = "Female") },
                            onClick = { gender="Female"
                                isExpanded=false
                            })
                    }
                }
            }




            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){

                ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
                    isExpanded=it
                }) {
                    TextField(value = formDuration,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        modifier=Modifier.menuAnchor()
                    )

                    ExposedDropdownMenu(expanded = isExpanded,
                        onDismissRequest = {
                            isExpanded=false
                        }
                    ){
                        DropdownMenuItem(text = {
                            Text(text = "1 Month") },
                            onClick = { formDuration="1 Month"
                                isExpanded=false
                            })
                        DropdownMenuItem(text = {
                            Text(text = "3 Months") },
                            onClick = { formDuration="3 Months"
                                isExpanded=false
                            })
                        DropdownMenuItem(text = {
                            Text(text = "6 Months") },
                            onClick = { formDuration="6 Months"
                                isExpanded=false
                            })
                        DropdownMenuItem(text = {
                            Text(text = "12 Months") },
                            onClick = { formDuration="12 Months"
                                isExpanded=false
                            })
                    }
                }
            }



            Button(onClick = {
                var actualDuration = (if (formDuration == "1 Month") {
                    1
                } else if (formDuration == "3 Months") {
                    3
                } else if (formDuration == "6 Months") {
                    6
                } else {
                    12
                }).toLong()

                var expiry = startingDate.plusMonths(actualDuration)


                var item = Item(
                    firstName,
                    lastName,
                    gender,
                    actualDuration,
                    phoneNumber,
                    dob,
                    startingDate,
                    expiry
                )


                var ob = addUserToFirebase()
                ob.addUser(item, context)
            }
            )
            {
                Text(text = "Submit")
            }

    }
}
    }

