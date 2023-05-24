package com.example.login.adapter

import com.example.login.model.artista
import com.example.login.model.galeria

interface artistaListener {
    fun onArtistaClicked(Artista: artista, position: Int)

}