package com.example.pruebaentrada.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaentrada.domain.GetLoginUseCase
import com.example.pruebaentrada.data.utils.DataState
import com.example.pruebaentrada.domain.model.DataUserItem

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel (): ViewModel() {
     val userData=MutableLiveData<DataUserItem>()
    val getLoginUseCase= GetLoginUseCase()

     init{

    }
    fun getLogin(user:String, password:String){
        viewModelScope.launch(Dispatchers.IO){
//            popularMovies.postValue(Respuesta.Loading())
            getLoginUseCase(user,password).let { current->

                when(current){
                    is DataState.Data -> {
                        userData.postValue(current.data)
                    }
                    is DataState.Error -> {
                    Log.d("tag", current.response.response?.message!!)
                    }
                }

            }


        }
    }

}