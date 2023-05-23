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
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray

class activity_menu : AppCompatActivity() {

private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarNavegacion()

        //--- Carga de datos
        val jsonGaleria = JSONArray("[\n" +
                "            {\n" +
                "                'artistagaleria' : 'Henciel Daniel Bulimar',\n" +
                "                'titulogaleria' : 'Memories',\n" +
                "                'preciogaleria' : '1,600',\n" +
                "                'imagengaleria' : 'https://artelista.s3.amazonaws.com/obras/big/3/5/5/1209702-607458d7c0c2a.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistagaleria' : 'María Berroterán',\n" +
                "                'titulogaleria' : 'Pallace',\n" +
                "                'preciogaleria' : '1,800',\n" +
                "                'imagengaleria' : 'https://artelista.s3.amazonaws.com/obras/big/8/3/9/1201563-602e9746f3abf.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistagaleria' : 'Marilin López',\n" +
                "                'titulogaleria' : 'Amanecer',\n" +
                "                'preciogaleria' : '1,200',\n" +
                "                'imagengaleria' : 'https://artelista.s3.amazonaws.com/obras/big/3/6/8/1204092-6006ef285e45d.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistagaleria' : 'German Aguirre',\n" +
                "                'titulogaleria' : 'Atardecer',\n" +
                "                'preciogaleria' : '800',\n" +
                "                'imagengaleria' : 'https://artelista.s3.amazonaws.com/obras/big/3/5/5/1209702-607458d7c0c2a.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistagaleria' : 'Brenda Martinez',\n" +
                "                'titulogaleria' : 'Hogar',\n" +
                "                'preciogaleria' : '1,100',\n" +
                "                'imagengaleria' : 'https://artelista.s3.amazonaws.com/obras/big/5/5/7/1191748-5f1033f19f2e4.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'artistagaleria' : 'Karla Martinez',\n" +
                "                'titulogaleria' : 'Memories',\n" +
                "                'preciogaleria' : '1,600',\n" +
                "                'imagengaleria' : 'https://artelista.s3.amazonaws.com/obras/big/7/2/3/1190859-5ef3a721f3127.jpg'\n" +
                "            }\n" +
                "        ]")
        val fireDB: FirebaseFirestore = FirebaseFirestore.getInstance()


    }
    protected fun configurarNavegacion()
    {
        val bmenu: BottomNavigationView= binding.navMenuArte
        NavigationUI.setupWithNavController(bmenu, Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu))

    }
}