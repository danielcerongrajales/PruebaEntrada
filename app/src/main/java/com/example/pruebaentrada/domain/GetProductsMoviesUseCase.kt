package com.example.pruebaentrada.domain

import com.example.pruebaentrada.data.ProductRepository
import com.example.pruebaentrada.data.model.tokenGener
import com.example.pruebaentrada.data.utils.DataState
import com.example.pruebaentrada.domain.model.valorItem


class GetProductsMoviesUseCase(){

    private val repository= ProductRepository()
    suspend operator fun invoke(tokenGener: tokenGener): DataState<valorItem> {
        return repository.getProducts(tokenGener)
    }


}