package com.example.cl.sprintfinalm6.local

import androidx.room.Entity

@Entity(tableName = "table_Phone", primaryKeys = ["id"])
data class PhoneEntity (
    val id :Int,
    val name:String,
    val price: Int,
    val image:String
        )