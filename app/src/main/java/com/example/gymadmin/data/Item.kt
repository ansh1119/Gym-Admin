package com.example.gymadmin.Data

import java.time.Instant
import java.time.LocalDate

data class Item(
    var firstName:String?=null,
    var lastName:String?=null,
    var gender:String?=null,
    var duration: Long?=null,
    var phone:String?=null,
    var dob:String?=null,
    var startingDate: String?=null,
    var endingDate:String?=null
){
    constructor():this(null,null,null,null,null,null,null,null)
}
