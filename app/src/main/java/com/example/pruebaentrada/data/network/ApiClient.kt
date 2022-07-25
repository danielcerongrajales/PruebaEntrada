package com.example.pruebaentrada.data.network

import com.example.pruebaentrada.data.model.User
import com.example.pruebaentrada.data.model.UserResponse
import com.example.pruebaentrada.data.model.tokenGener
import com.example.pruebaentrada.data.model.valor
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {

    @POST("proximatetools/dev/webadmin/testproximate/login")
    suspend fun getLoginUsuario(@Body  body: User): Response<UserResponse>

    @POST("proximatetools/dev/webadmin/testproximate/getproducts")
    suspend fun getProductos(@Body  body: tokenGener): Response<valor>



}