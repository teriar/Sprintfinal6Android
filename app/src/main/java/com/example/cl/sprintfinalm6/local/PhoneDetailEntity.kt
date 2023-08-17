package com.example.cl.sprintfinalm6.local

import androidx.room.Entity

@Entity(tableName = "table_detailPhone", primaryKeys = ["id"])
data class PhoneDetailEntity (
       val id:Int,
       val name:String,
       val price:Int,
       val image:String,
       val description:String,
       val lastPrice:Int,
       val credit:Boolean
        )