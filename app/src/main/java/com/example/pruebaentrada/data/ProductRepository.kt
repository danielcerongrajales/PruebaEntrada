package com.example.pruebaentrada.data

import com.example.pruebaentrada.data.utils.MessageType
import com.example.pruebaentrada.data.utils.Response as myResponse
import com.example.pruebaentrada.data.utils.StateMessage
import com.example.pruebaentrada.data.model.UserResponse
import com.example.pruebaentrada.data.network.MovieService
import com.example.pruebaentrada.data.model.tokenGener
import com.example.pruebaentrada.data.model.valor
import com.example.pruebaentrada.data.network.ApiResponseHandler
import com.example.pruebaentrada.data.utils.DataState
import com.example.pruebaentrada.data.utils.safeApiCall
import com.example.pruebaentrada.domain.model.DataUserItem
import com.example.pruebaentrada.domain.model.toDomain
import com.example.pruebaentrada.domain.model.valorItem
import kotlinx.coroutines.Dispatchers
import retrofit2.Response


class ProductRepository(){
    private val api = MovieService()
    suspend fun getLogin(user: String, password: String): DataState<DataUserItem> {

        val networkResult =safeApiCall(Dispatchers.IO)  {       api.getLogin(user,password)}

        val response = object: ApiResponseHandler<DataUserItem, Response<UserResponse>>(
            response = networkResult,
//            stateEvent = null
        ){


            override suspend fun handleSuccess(resultObj: Response<UserResponse>): DataState<DataUserItem>? {
                return DataState.Data(
                    response = StateMessage(
                        myResponse(
                        message = "get from network",
                        messageType = MessageType.Success
                    )
                    ),
                    data = resultObj.body()?.dataUser?.toDomain()
                    ,
                )
            }


        }.getResult()

        return response!!
    }
    suspend fun getProducts(tokenGener: tokenGener): DataState<valorItem> {

        val networkResult =safeApiCall(Dispatchers.IO)  {       api.getProducts(tokenGener)}

        val response = object: ApiResponseHandler<valorItem, Response<valor>>(
            response = networkResult,
//            stateEvent = null
        ){


            override suspend fun handleSuccess(resultObj: Response<valor>): DataState<valorItem>? {
                return DataState.Data(
                    response = StateMessage(
                        myResponse(
                            message = "get from network",
                            messageType = MessageType.Success
                        )
                    ),
                    data = resultObj.body()?.toDomain()
                    ,
                )
            }


        }.getResult()

        return response!!
    }


}