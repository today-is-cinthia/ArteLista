package com.example.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artelista.model.evento
import com.example.login.data.ICallback
import com.example.login.data.serviceFirestore

class EventoViewModel: ViewModel() {

    //Inicializacion
    val firestoreService = serviceFirestore()
    val listevento: MutableLiveData<List<evento>> = MutableLiveData()
    var isLoad = MutableLiveData<Boolean>()
    //GetEvento
    fun getEventoVM(){
        firestoreService.getevento(object : ICallback<List<evento>> {
            override fun onSuccess(result: List<evento>?) {
                listevento.postValue(result!!)
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