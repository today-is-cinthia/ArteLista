package com.example.login

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.login.databinding.ActivityMenuBinding

class activity_menu : AppCompatActivity() {

private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarNavegacion()

    }
    protected fun configurarNavegacion()
    {
        val bmenu: BottomNavigationView= binding.navMenuArte
        NavigationUI.setupWithNavController(bmenu, Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu))

    }
}