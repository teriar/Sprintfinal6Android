package com.example.cl.sprintfinalm6.data.local


import com.example.cl.sprintfinalm6.data.remote.Phone
import com.example.cl.sprintfinalm6.data.remote.toEntity
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MapperktTest {

    @Test
    fun testToEntity() {

        var phone = Phone(id = 1, name = "telefono", price = 123456, image = "imageUrl")
        val result = phone.toEntity()
        //assertEquals(nombreRaza,result.raza)
        assertThat(result.id).isEqualTo(phone.id)

    }
}