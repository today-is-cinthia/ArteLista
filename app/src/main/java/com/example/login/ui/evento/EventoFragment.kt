package com.example.login.ui.evento

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.adapter.adapterevento
import com.example.artelista.adapter.adaptergaleria
import com.example.artelista.model.evento
import com.example.login.R
import com.example.login.databinding.FragmentEventoBinding
import com.example.login.model.artista

class EventoFragment : Fragment(){
    private var fbinding: FragmentEventoBinding? = null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding= FragmentEventoBinding.inflate(inflater,container, false)
        val view:View=binding.root
        //.........
        val reciclerevento: RecyclerView = fbinding!!.rvEvento
        reciclerevento.layoutManager= LinearLayoutManager(context)
        val adapterEvento= adapterevento(getEventos(), R.layout.item_evento, Activity())
        reciclerevento.adapter= adapterEvento
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    //------Cargar con valores hardcord Galeria

    fun getEventos(): ArrayList<evento> {
        //--------------
        val Evento: ArrayList<evento> = ArrayList<evento>()
        //-------------

        Evento.add(evento("Armando Jose Agguirre", "Oleo","8:00"))
        Evento.add(evento("German Traña Obando", "Lapiz","10:00"))
        Evento.add(evento("Pol Ledent", "Acrilico","03:00"))
        Evento.add(evento("Maribel Flores", "Oleo","11:00"))
        Evento.add(evento("Nana Tchelidze", "Canvas","04:00"))
        Evento.add(evento("Armando Jose Agguirre", "Oleo","8:00"))
        Evento.add(evento("German Traña Obando", "Lapiz","10:00"))
        Evento.add(evento("Pol Ledent", "Acrilico","03:00"))
        Evento.add(evento("Maribel Flores", "Oleo","11:00"))
        Evento.add(evento("Nana Tchelidze", "Canvas","04:00"))
        Evento.add(evento("Armando Jose Agguirre", "Oleo","8:00"))
        Evento.add(evento("German Traña Obando", "Lapiz","10:00"))
        Evento.add(evento("Pol Ledent", "Acrilico","03:00"))
        Evento.add(evento("Maribel Flores", "Oleo","11:00"))
        Evento.add(evento("Nana Tchelidze", "Canvas","04:00"))
        return Evento
    }
}