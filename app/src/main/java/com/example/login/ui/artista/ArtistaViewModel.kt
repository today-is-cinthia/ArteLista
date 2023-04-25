package com.example.login.ui.Galeria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArtistaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Sexo"
    }
    val text: LiveData<String> = _text
}