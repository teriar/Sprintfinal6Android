package com.example.cl.sprintfinalm6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhoneDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhone(PhoneEntity: PhoneEntity)



    @Query("Select * from table_Phone order by id asc")
    fun getPhones(): LiveData<List<PhoneEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoneDetail(PhoneDetail: PhoneDetailEntity)

    @Query("Select * from table_detailPhone where id like :id")
    fun getDetailPhone(id:Int): LiveData<List<PhoneDetailEntity>>
}