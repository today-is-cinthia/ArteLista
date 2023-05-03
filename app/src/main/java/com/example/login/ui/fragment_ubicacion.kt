package com.example.login.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.example.login.R
import com.example.login.databinding.FragmentUbicacionBinding


class fragment_ubicacion : DialogFragment() {

    private var fbinding:FragmentUbicacionBinding?=null
    private  val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)
        fbinding = FragmentUbicacionBinding.inflate(inflater, container, false)
        val view :View = binding.root
        val toolbar: Toolbar =  fbinding!!.tbUbicacion
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_left)
        toolbar.setTitle("Ubicación")
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }


        val img_mapa:ImageView = fbinding!!.imgMapa
        img_mapa.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.fragment_ubicaciondet2)
        }

        return view
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}