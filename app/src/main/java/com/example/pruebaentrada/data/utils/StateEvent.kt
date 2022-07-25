package com.example.pruebaentrada.data.utils


interface StateEvent {

    fun errorInfo(): String
    fun eventName(): String
    fun shouldDisplayProgressBar(): Boolean
}
