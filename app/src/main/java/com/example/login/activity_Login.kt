package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.login.databinding.ActivityCrearcuentaBinding
import com.example.login.databinding.ActivityLoginBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class activity_Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_login)
        setContentView(view)

        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        binding.btnLogin.setOnClickListener({ v ->
            if (validarUsuario().equals(true)) {
                firebaseAuth.signInWithEmailAndPassword(binding.editUserName.text.toString(), binding.editPassword.text.toString()).addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this,
                                    activity_menu::class.java))
                                Toast.makeText(this, "Bienvenido",
                                    Toast.LENGTH_SHORT).show();
                                binding.editUserName.setText("")
                                binding.editUserName.setText("")
                            } else {
                                Toast.makeText(this, "El usuario y clave no existen", Toast.LENGTH_SHORT).show();
                            }
                        })
            }
        })
//---------------------

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

    //Validar que los campos no sean nulos
    fun validarUsuario(): Boolean {
        try {
            var validaok: Boolean = false
//-- El email es un valor requerido
            if (binding.editUserName.text?.length?.equals(0)!!) {
                binding.editUserName.requestFocus()
                binding.editUserName.setError("Debe ingresar su correo electrónico")
                    return validaok
            }
//-- La contraseña es un valor requerido
            if (binding.editPassword.text?.length?.equals(0)!!) {
                binding.editPassword.requestFocus()
                binding.editPassword.setError("Debe ingresar una contraseña")
                return validaok
            }
            validaok = true
            return validaok
        } catch (e: Exception) {
            e.message?.let { Log.e("Error en valida", it) };
            return false;
        }
    }
}