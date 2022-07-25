package com.example.pruebaentrada.domain.model

import com.example.pruebaentrada.data.model.DataUser

class DataUserItem (
    val id: Int,
    val lastName: String,
    val name: String,
    val position: String,
    val role: String,
    val userToken: String
)

 fun DataUser.toDomain()= DataUserItem(
     id,
 lastName,
 name,
 position,
 role,
 userToken,
)