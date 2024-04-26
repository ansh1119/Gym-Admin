package com.example.gymadmin.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gymadmin.R
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddMember() {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var gender by remember {
        mutableStateOf("")
    }
    var duration by remember {
        mutableStateOf("")
    }
    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }

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
                    TextField(value = duration,
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
                            onClick = { duration="1 Month"
                                isExpanded=false
                            })
                        DropdownMenuItem(text = {
                            Text(text = "3 Months") },
                            onClick = { duration="3 Months"
                                isExpanded=false
                            })
                        DropdownMenuItem(text = {
                            Text(text = "6 Months") },
                            onClick = { duration="6 Months"
                                isExpanded=false
                            })
                        DropdownMenuItem(text = {
                            Text(text = "12 Months") },
                            onClick = { duration="12 Months"
                                isExpanded=false
                            })
                    }
                }
            }


        }
    }
}