package com.example.pruebaentrada.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebaentrada.data.model.Product
import com.example.pruebaentrada.domain.GetProductsMoviesUseCase
import com.example.pruebaentrada.data.model.tokenGener
import com.example.pruebaentrada.data.utils.DataState

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel (private val state: SavedStateHandle): ViewModel() {
    val productsList=MutableLiveData<List<Product>>()
    val getProductsUseCase= GetProductsMoviesUseCase()

     init{
         val a =state.get<String>("as")
             ?: throw IllegalStateException("Movie Id not found in the state handle")
        viewModelScope.launch(Dispatchers.IO){
            getProductsUseCase(tokenGener(a)).let {current->
                when(current){
                    is DataState.Data -> productsList.postValue(current.data?.data?.products)
                    is DataState.Error -> TODO()
                }
            }

        }
    }


}