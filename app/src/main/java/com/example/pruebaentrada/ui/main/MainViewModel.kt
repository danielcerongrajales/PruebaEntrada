package com.example.pruebaentrada.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaentrada.domain.GetLoginUseCase
import com.example.pruebaentrada.data.utils.DataState
import com.example.pruebaentrada.domain.model.DataUserItem

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (): ViewModel() {
     val popularMovies=MutableLiveData<DataUserItem>()
    val popular=MutableLiveData<Boolean>()
    val getLoginUseCase= GetLoginUseCase()

     init{

         popular.postValue(true)
    }
    fun getLogin(user:String, password:String){
        viewModelScope.launch(Dispatchers.IO){
//            popularMovies.postValue(Respuesta.Loading())
            getLoginUseCase(user,password).let { current->

                when(current){
                    is DataState.Data -> {
                        popularMovies.postValue(current.data)
                    }
                    is DataState.Error -> {
                    Log.d("tag", current.response.response?.message!!)
                    }
                }

            }


        }
    }

}