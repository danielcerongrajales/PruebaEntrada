package com.example.pruebaentrada.domain.model

import com.example.pruebaentrada.data.model.Data
import com.example.pruebaentrada.data.model.valor
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


data class valorItem(
    val codeStatus: String,
    @SerializedName("data")
    val _data: String,
    val message: String,
    val status: Boolean,
    val data: Data
)

fun valor.toDomain() = valorItem(
     codeStatus,
    _data,
 message,
 status,
    data
)