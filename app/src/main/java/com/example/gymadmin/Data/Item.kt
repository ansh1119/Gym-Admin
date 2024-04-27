package com.example.gymadmin.Data

import java.time.Instant
import java.time.LocalDate

data class Item(
    var firstName:String,
    var lastName:String,
    var gender:String,
    var duration: Long,
    var phone:String,
    var dob:String,
    var startingDate: LocalDate,
    var endingDate: LocalDate
)
