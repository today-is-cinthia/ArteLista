package com.example.login.ui

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.adapter.adapterartista
import com.example.login.databinding.FragmentArtistaBinding
import com.example.login.databinding.FragmentArtistadetBinding
import com.example.login.model.artista

class fragment_artistadet : DialogFragment() {
    private var fbinding: FragmentArtistadetBinding?=null
    private  val binding get() = fbinding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)
        fbinding = FragmentArtistadetBinding.inflate(inflater, container, false)
        val view :View = binding.root

        val toolbar: androidx.appcompat.widget.Toolbar =  fbinding!!.tbArtistaDet

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_left)
        toolbar.setTitle("Datos del Artista")
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            dismiss()
            Navigation.findNavController(it).navigateUp()
        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}