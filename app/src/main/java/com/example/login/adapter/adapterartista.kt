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

class adapterartista(Artistas: ArrayList<artista>,
                     resource:Int, activity: Activity):
    RecyclerView.Adapter<adapterartista.ArtistaViewHolder>() {
    private val artistas: ArrayList<artista>
    private val resource: Int
    private val activity: Activity

    init {
        this.artistas= Artistas
        this.resource= resource
        this.activity= activity

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ArtistaViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(resource, parent,false)
        return ArtistaViewHolder (view)
    }

    override fun onBindViewHolder(holder:ArtistaViewHolder, position: Int) {
        val artista: artista =artistas[position]
        holder.tvNombreartista.setText(artista.getNombreArtista())
        holder.tvCategoriaArtista.setText(artista.getCategoriaArtista())
        holder.tvPaisArtista.setText(artista.getPaisArtista())
        holder.itemView.setOnClickListener{
            Navigation.findNavController(holder.itemView).navigate(R.id.fragment_artistadet)
        }

    }

    override fun getItemCount(): Int {
        return artistas.size
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