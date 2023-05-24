package com.example.artelista.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.artelista.model.evento
import com.example.login.adapter.eventoListener
import com.example.login.adapter.galeriaListener
import com.example.login.model.galeria

class adapterevento(val EventoListener: eventoListener):
    RecyclerView.Adapter<adapterevento.EventoViewHolder>() {

    val listEvento= ArrayList<evento>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): EventoViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent,false)
        return EventoViewHolder (view)
    }

    override fun onBindViewHolder(holder:EventoViewHolder, position: Int) {
        val evento: evento = listEvento[position]
        holder.tvTituloEvento.setText(evento.tituloevento)
        holder.tvCategoriaEvento.setText(evento.categoriaevento)
        holder.tvHoraEvento.setText(evento.horaevento)
        holder.itemView.setOnClickListener{
            EventoListener.onEventoClicked(evento, position)
            Navigation.findNavController(holder.itemView).navigate(R.id.fragment_ubicacion)
        }

    }

    override fun getItemCount(): Int {
        return listEvento.size
    }

    fun updateData(data: List<evento>){
        listEvento.clear()
        listEvento.addAll(data!!)
        notifyDataSetChanged()
    }

    inner class EventoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTituloEvento: TextView
        val tvCategoriaEvento: TextView
        val tvHoraEvento: TextView

        init {
            tvTituloEvento=itemView.findViewById<View>(R.id.tvTituloEvento)as TextView
            tvCategoriaEvento=itemView.findViewById<View>(R.id.tvCategoriaEvento)as TextView
            tvHoraEvento=itemView.findViewById<View>(R.id.tvEventoHora)as TextView

        }
    }
}