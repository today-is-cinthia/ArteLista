package com.example.login.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artelista.adapter.adapterevento
import com.example.artelista.adapter.adaptergaleria
import com.example.artelista.model.evento
import com.example.login.R
import com.example.login.adapter.eventoListener
import com.example.login.databinding.FragmentEventoBinding
import com.example.login.model.artista
import com.example.login.model.galeria
import com.example.login.viewmodel.EventoViewModel
import com.example.login.viewmodel.GaleriaViewModel

class EventoFragment : Fragment(), eventoListener{
    private var fbinding: FragmentEventoBinding? = null
    private val binding get() = fbinding!!
    private lateinit var eventoAdapter: adapterevento
    private lateinit var vmodelEvento: EventoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding= FragmentEventoBinding.inflate(inflater,container, false)
        val view:View=binding.root
        //.........

        vmodelEvento = ViewModelProvider(this).get(EventoViewModel::class.java)
        vmodelEvento.getEventoVM()
        eventoAdapter = adapterevento(this)
        binding.rvEvento.apply { layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = eventoAdapter
        }
        observerViewModel()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    fun observerViewModel(){
        vmodelEvento.listevento.observe(viewLifecycleOwner, Observer<List<evento>>{ evento ->
            eventoAdapter.updateData(evento)
        })
        vmodelEvento.isLoad.observe(viewLifecycleOwner, Observer {
            if(it != null)
            {
                binding.progressevento.visibility = View.INVISIBLE
            }
        })
    }

    override fun onEventoClicked(Evento: evento, position: Int) {
        val bundle = bundleOf("evento" to Evento)
       // NavHostFragment.findNavController(this).navigate(R.id., bundle)
    }
}