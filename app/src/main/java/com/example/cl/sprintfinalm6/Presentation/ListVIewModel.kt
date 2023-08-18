package com.example.cl.sprintfinalm6.Presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cl.sprintfinalm6.data.Repository
import com.example.cl.sprintfinalm6.data.local.PhoneDatabase
import com.example.cl.sprintfinalm6.data.remote.PhoneRetrofit
import kotlinx.coroutines.launch

class ListVIewModel(application: Application):AndroidViewModel(application) {
    private val repository:Repository

    fun phoneLiveData() = repository.getPhoneEntity()

    fun detailLiveData(id:Int) = repository.getPhoneDetailEntity(id)

    init {
        val api = PhoneRetrofit.getRetrofitPhone()
        val dao = PhoneDatabase.getDataBase(application).getPhoneDao()
        repository = Repository(api,dao)
    }
    fun getDataPhones()= viewModelScope.launch {
        repository.getPhones()
    }
    fun getDetailPhone(id:Int)=viewModelScope.launch {
        repository.getDetailPhone(id)
    }

}