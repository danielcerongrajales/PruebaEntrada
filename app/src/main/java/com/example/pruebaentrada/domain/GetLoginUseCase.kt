package com.example.pruebaentrada.domain

import com.example.pruebaentrada.data.ProductRepository
import com.example.pruebaentrada.data.utils.DataState
import com.example.pruebaentrada.domain.model.DataUserItem


class GetLoginUseCase(){

    private val repository= ProductRepository()
    suspend operator fun invoke(user: String, password: String): DataState<DataUserItem> {
        val a= repository.getLogin(user,password)

        return a
    }


}