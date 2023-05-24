package com.example.login.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.R
import com.example.login.adapter.adapterartista
import com.example.login.adapter.artistaListener
import com.example.login.databinding.FragmentArtistaBinding
import com.example.login.model.artista
import com.example.login.viewmodel.ArtistaViewModel

class ArtistaFragment : Fragment(), artistaListener {

    private var fbinding:FragmentArtistaBinding?=null
    private  val binding get() = fbinding!!
    private lateinit var artistaAdapter: adapterartista
    private lateinit var vmodelArtista: ArtistaViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentArtistaBinding.inflate(inflater, container, false)
        val view :View = binding.root

        val toolbar: androidx.appcompat.widget.Toolbar =  fbinding!!.tbArtista

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle(getString(R.string.strArtista))
        toolbar.setTitleTextColor(Color.WHITE)

        vmodelArtista = ViewModelProvider(this).get(ArtistaViewModel::class.java)
        vmodelArtista.getArtistaVM()
        artistaAdapter = adapterartista(this)
        binding.rvArtista.apply { layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = artistaAdapter
        }
        observerViewModel()
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    fun observerViewModel(){
        vmodelArtista.listartista.observe(viewLifecycleOwner, Observer<List<artista>>{ artista ->
            artistaAdapter.updateData(artista)
        })
        vmodelArtista.isLoad.observe(viewLifecycleOwner, Observer {
            if(it != null)
            {
                binding.progressartista.visibility = View.INVISIBLE
            }
        })
    }


    override fun onArtistaClicked(Artista: artista, position: Int) {
        val bundle = bundleOf("artista" to Artista)
        NavHostFragment.findNavController(this).navigate(R.id.fragment_artistadet, bundle)
    }



}