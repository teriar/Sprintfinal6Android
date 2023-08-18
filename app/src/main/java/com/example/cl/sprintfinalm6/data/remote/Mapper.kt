package com.example.cl.sprintfinalm6.data.remote

import com.example.cl.sprintfinalm6.data.local.PhoneEntity

fun Phone.toEntity():PhoneEntity = PhoneEntity(this.id,this.name,this.price,this.image)