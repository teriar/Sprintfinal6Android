package com.example.cl.sprintfinalm6.data.remote

data class Phone(
    val id:Int,
    val name:String,
    val Price:Int,
    val image:String
)

data class Phones(
    val listPhones:List<Phone>
)