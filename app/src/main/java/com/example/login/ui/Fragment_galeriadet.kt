package com.example.login.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.example.login.R
import com.example.login.databinding.FragmentGaleriadetBinding


class fragment_galeriadet : DialogFragment() {

    private var fbinding: FragmentGaleriadetBinding?=null
    private val binding get() = fbinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)
        fbinding = FragmentGaleriadetBinding.inflate(inflater, container, false)
        val view: View = binding.root
        val toolbar: Toolbar =  fbinding!!.tbGaleriaDet

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_left)
        toolbar.setTitle("")
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

