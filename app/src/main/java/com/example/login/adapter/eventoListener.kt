package com.example.login.adapter

import com.example.artelista.model.evento

interface eventoListener {

    fun onEventoClicked(Evento: evento, position: Int)
}