package com.example.cl.sprintfinalm6.data.remote

import com.example.cl.sprintfinalm6.data.local.PhoneDetailEntity

fun DetailPhone.toEntityDetail():PhoneDetailEntity = PhoneDetailEntity(
    this.id,
    this.name,
    this.price,
    this.image,
    this.description,
    this.lastPrice,
    this.credit
)