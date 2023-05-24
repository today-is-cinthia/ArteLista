package com.example.login.ui

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artelista.adapter.adaptergaleria
import com.example.login.R
import com.example.login.adapter.galeriaListener
import com.example.login.databinding.FragmentGaleriaBinding
import com.example.login.model.galeria
import com.example.login.viewmodel.GaleriaViewModel

class GaleriaFragment : Fragment(), galeriaListener {

private var fbinding: FragmentGaleriaBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = fbinding!!
  private lateinit var galeriaAdapter: adaptergaleria
  private lateinit var vmodelGaleria: GaleriaViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
      fbinding = FragmentGaleriaBinding.inflate(inflater, container, false)
      val view: View = binding.root

      //--------------
      //- Personalizar el toolbar
      val toolbar: Toolbar = fbinding!!.tbgaleria
      (activity as AppCompatActivity).setSupportActionBar(toolbar)
      toolbar.setTitle(getString(R.string.strGaleria))
      toolbar.setTitleTextColor(Color.WHITE)
      //------------

      vmodelGaleria = ViewModelProvider(this).get(GaleriaViewModel::class.java)
      vmodelGaleria.getGaleriaVM()
      galeriaAdapter = adaptergaleria(this)
      binding.rvGaleria.apply { layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        adapter = galeriaAdapter
      }
      observerViewModel()
      return view
  }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
    fun observerViewModel(){
        vmodelGaleria.listgaleria.observe(viewLifecycleOwner, Observer<List<galeria>>{galeria ->
            galeriaAdapter.updateData(galeria)
        })
        vmodelGaleria.isLoad.observe(viewLifecycleOwner, Observer {
            if(it != null)
            {
                binding.progressgaleria.visibility = View.INVISIBLE
            }
        })
    }

    override fun onGaleriaClicked(Galeria: galeria, position: Int) {
        val bundle = bundleOf("galeria" to Galeria)
        NavHostFragment.findNavController(this).navigate(R.id.fragment_galeriadet, bundle)
    }

}

