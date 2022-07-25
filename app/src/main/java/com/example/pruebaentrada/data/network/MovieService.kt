package com.example.pruebaentrada.data.network

//import com.google.gson.Gson

import com.example.pruebaentrada.data.model.User
import com.example.pruebaentrada.core.RetrofitHelper
import com.example.pruebaentrada.data.model.UserResponse
import com.example.pruebaentrada.data.model.tokenGener
import com.example.pruebaentrada.data.model.valor
import retrofit2.Response

class MovieService (){
    private val retro = RetrofitHelper().getRetrofit()
    private val retrofit=  retro.create(ApiClient::class.java)


    suspend fun getLogin(user: String, password: String): Response<UserResponse> {

      val a  =retrofit.getLoginUsuario(User())
        return a
    }
    suspend fun getProducts(tokenGener: tokenGener):  Response<valor>{
        val a  =retrofit.getProductos(tokenGener)
        return a
    }

}