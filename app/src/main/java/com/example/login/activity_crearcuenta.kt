package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.login.databinding.ActivityCrearcuentaBinding

class activity_crearcuenta : AppCompatActivity() {

    private lateinit var binding: ActivityCrearcuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearcuentaBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_crearcuenta)
        setContentView(view)
        val toolbar:Toolbar = binding.tbCrearCuenta
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Crear cuenta")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}