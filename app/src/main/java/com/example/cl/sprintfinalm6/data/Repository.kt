package com.example.cl.sprintfinalm6.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.cl.sprintfinalm6.data.local.PhoneDao
import com.example.cl.sprintfinalm6.data.local.PhoneDetailEntity
import com.example.cl.sprintfinalm6.data.local.PhoneEntity
import com.example.cl.sprintfinalm6.data.remote.DetailPhone
import com.example.cl.sprintfinalm6.data.remote.Phone
import com.example.cl.sprintfinalm6.data.remote.PhoneApi
import com.example.cl.sprintfinalm6.data.remote.toEntity
import com.example.cl.sprintfinalm6.data.remote.toEntityDetail

import retrofit2.Response

class Repository(private val PhoneApi: PhoneApi, private val PhoneDao: PhoneDao) {
    fun getPhoneEntity(): LiveData<List<PhoneEntity>> = PhoneDao.getPhones()
    fun getPhoneDetailEntity(id:Int): LiveData<PhoneDetailEntity> = PhoneDao.getDetailPhone(id)

    suspend fun  getPhones(){
        val response: Response<List<Phone>> = PhoneApi.getData()// aca llegan los datos
        if(response.isSuccessful){ //??llegaron los datos
        val resp = response.body()?.forEach{
            val phoneEntity = it.toEntity()
            PhoneDao.insertPhone(phoneEntity)
        }
        }else{
            Log.e("repositorio", response.errorBody().toString())
        }
    }

    suspend fun getDetailPhone(id:Int){
        val response:Response<DetailPhone> = PhoneApi.getDetailPhone(id)
        if(response.isSuccessful){
           val detail:DetailPhone = response.body()!!

            val phoneDetailEntity = detail.toEntityDetail()
            PhoneDao.insertPhoneDetail(phoneDetailEntity)
        }else{
            Log.e("repositorio", response.errorBody().toString())
        }
    }
}