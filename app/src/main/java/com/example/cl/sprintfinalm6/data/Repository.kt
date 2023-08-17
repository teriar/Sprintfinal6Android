package com.example.cl.sprintfinalm6.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.cl.sprintfinalm6.data.local.PhoneDao
import com.example.cl.sprintfinalm6.data.local.PhoneDetailEntity
import com.example.cl.sprintfinalm6.data.local.PhoneEntity
import com.example.cl.sprintfinalm6.data.remote.Phone
import com.example.cl.sprintfinalm6.data.remote.PhoneApi
import com.example.cl.sprintfinalm6.data.remote.Phones
import retrofit2.Response

class Repository(private val PhoneApi: PhoneApi, private val PhoneDao: PhoneDao) {
    fun getPhoneEntity(): LiveData<List<PhoneEntity>> = PhoneDao.getPhones()
    fun getPhoneDetailEntity(id:Int): LiveData<List<PhoneDetailEntity>> = PhoneDao.getDetailPhone(id)

    suspend fun  getPhones(){
        val response: Response<Phones> = PhoneApi.getData()// aca llegan los datos
        if(response.isSuccessful){ //??llegaron los datos
        val resp = response.body()



        }else{
            Log.e("repositorio", response.errorBody().toString())
        }
    }
}