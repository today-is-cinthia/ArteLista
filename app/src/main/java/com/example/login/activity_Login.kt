package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.login.databinding.ActivityCrearcuentaBinding
import com.example.login.databinding.ActivityLoginBinding

class activity_Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_login)
        setContentView(view)
        val btnIniciarSesion:Button = binding.btnLogin
        btnIniciarSesion.setOnClickListener({v->
            val intent = Intent(v.getContext(), activity_menu::class.java)
            startActivity(intent)
        })

        val tvCrearCuenta: TextView = binding.tvCreaUnaAqui
        tvCrearCuenta.setOnClickListener ({v->
            val intent  = Intent(v.getContext(), activity_crearcuenta::class.java)
            startActivity(intent)
        })
    }
}