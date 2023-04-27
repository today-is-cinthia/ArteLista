package com.example.login.ui.artista

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.adapter.adapterevento
import com.example.artelista.model.evento
import com.example.login.R
import com.example.login.adapter.adapterartista
import com.example.login.databinding.FragmentArtistaBinding
import com.example.login.databinding.FragmentUbicacionBinding
import com.example.login.model.artista

class ArtistaFragment : Fragment() {

    private var fbinding:FragmentArtistaBinding?=null
    private  val binding get() = fbinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentArtistaBinding.inflate(inflater, container, false)
        val view :View = binding.root
        val reciclerartista: RecyclerView = fbinding!!.rvArtista
        reciclerartista.layoutManager= LinearLayoutManager(context)
        val adapterartista= adapterartista(getArtistas(), R.layout.item_artista, Activity())
        reciclerartista.adapter= adapterartista
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    fun getArtistas(): ArrayList<artista> {
        //--------------
        val Artista: ArrayList<artista> = ArrayList<artista>()
        //-------------
        Artista.add(artista("Armando Jose Agguirre", "Oleo","Niacragua"))
        Artista.add(artista("German Traña Obando", "Lapiz","Panama"))
        Artista.add(artista("Pol Ledent", "Acrilico","Ecuador"))
        Artista.add(artista("Maribel Flores", "Oleo","Costa Rica"))
        Artista.add(artista("Nana Tchelidze", "Canvas","Guatemala"))
        Artista.add(artista("Armando Jose Agguirre", "Oleo","El Salvdor"))
        Artista.add(artista("German Traña Obando", "Lapiz","Honduras"))
        Artista.add(artista("Pol Ledent", "Acrilico","Chile"))
        Artista.add(artista("Maribel Flores", "Oleo","España"))
        Artista.add(artista("Nana Tchelidze", "Canvas","Argentina"))
        Artista.add(artista("Armando Jose Agguirre", "Oleo","Peru"))
        Artista.add(artista("German Traña Obando", "Lapiz","Ecudor"))
        Artista.add(artista("Pol Ledent", "Acrilico","Nicragua"))
        Artista.add(artista("Maribel Flores", "Oleo","Nicaragua"))
        Artista.add(artista("Nana Tchelidze", "Canvas","Argentina"))
        return Artista
    }
}