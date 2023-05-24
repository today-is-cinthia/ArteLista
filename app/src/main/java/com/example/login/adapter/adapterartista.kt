package com.example.login.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.adapter.adapterevento
import com.example.artelista.model.evento
import com.example.login.R
import com.example.login.model.artista
import com.example.login.model.galeria
import com.google.api.ResourceProto.resource

class adapterartista(val ArtistaListener: artistaListener):
    RecyclerView.Adapter<adapterartista.ArtistaViewHolder>() {

    var listArtista = ArrayList<artista>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ArtistaViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_artista, parent,false)
        return ArtistaViewHolder (view)
    }

    override fun onBindViewHolder(holder:ArtistaViewHolder, position: Int) {
        val artista: artista =listArtista[position]
        holder.tvNombreartista.setText(artista.nombreartista)
        holder.tvCategoriaArtista.setText(artista.categoriaartista)
        holder.tvPaisArtista.setText(artista.paisartista)
        holder.itemView.setOnClickListener{
            Navigation.findNavController(holder.itemView).navigate(R.id.fragment_artistadet)
        }

    }

    override fun getItemCount(): Int {
        return listArtista.size
    }


    fun updateData(data: List<artista>){
        listArtista.clear()
        listArtista.addAll(data!!)
        notifyDataSetChanged()
    }


    inner class ArtistaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNombreartista: TextView
        val tvCategoriaArtista: TextView
        val tvPaisArtista: TextView

        init {
            tvNombreartista=itemView.findViewById<View>(R.id.tvNombreArtista)as TextView
            tvCategoriaArtista=itemView.findViewById<View>(R.id.tvCategoriaArtista)as TextView
            tvPaisArtista=itemView.findViewById<View>(R.id.tvPaisArtista)as TextView

        }
    }
}