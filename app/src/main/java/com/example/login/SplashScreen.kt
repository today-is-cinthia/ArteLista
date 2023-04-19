package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.login.databinding.ActivityCrearcuentaBinding
import com.example.login.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        try
        {
            super.onCreate(savedInstanceState)
            binding = ActivitySplashScreenBinding.inflate(layoutInflater)
            val view = binding.root
            //setContentView(R.layout.activity_crearcuenta)
            setContentView(view)
//Agregamos la referencia al ImageView
            val LogoApp: ImageView = binding.imgArteLista
            val Logotext = binding.textArtelista
            val AnimLogo: Animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
            val AnimText: Animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
            LogoApp.startAnimation(AnimLogo)
            Logotext.startAnimation(AnimText)
            
//Intent para crear instancia de la activity Login
            val intent = Intent(this, activity_Login::class.java)
            AnimLogo.setAnimationListener(object:
                Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                }
                override fun onAnimationEnd(animation: Animation?) {
                    startActivity(intent)
                    finish()
                }
                override fun onAnimationRepeat(animation: Animation?) {
                }
            })
        }
        catch (e:java.lang.Exception)
        { e.printStackTrace() }
    }
}