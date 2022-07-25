package com.example.pruebaentrada.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SlideshowViewModel(private val state: SavedStateHandle) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        val a =state.get<String>("as")
            ?: throw IllegalStateException("Movie Id not found in the state handle")
        value ="token $a"
    }
    val text: LiveData<String> = _text
}