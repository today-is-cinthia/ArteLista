package com.example.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.data.ICallback
import com.example.login.data.serviceFirestore
import com.example.login.model.galeria

class GaleriaViewModel: ViewModel() {

    //Inicializacion
    val firestoreService = serviceFirestore()
    val listgaleria: MutableLiveData<List<galeria>> = MutableLiveData()
    var isLoad = MutableLiveData<Boolean>()
    //GetGaleria
    fun getGaleriaVM(){
        firestoreService.getgaleria(object : ICallback<List<galeria>>{
            override fun onSuccess(result: List<galeria>?) {
                listgaleria.postValue(result!!)
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