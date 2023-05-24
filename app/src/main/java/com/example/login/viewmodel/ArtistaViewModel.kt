package com.example.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.data.ICallback
import com.example.login.data.serviceFirestore
import com.example.login.model.artista
import com.example.login.model.galeria

class ArtistaViewModel: ViewModel() {

    //Inicializacion
    val firestoreService = serviceFirestore()
    val listartista: MutableLiveData<List<artista>> = MutableLiveData()
    var isLoad = MutableLiveData<Boolean>()

    //get Artista
    fun getArtistaVM(){
        firestoreService.getartista(object : ICallback<List<artista>> {
            override fun onSuccess(result: List<artista>?) {
                listartista.postValue(result!!)
                cargaFinalizada()
            }
            override fun onFailed(exception: Exception) {
                cargaFinalizada()
            }
        })
    }

    fun cargaFinalizada(){
        isLoad.value = true
    }
}