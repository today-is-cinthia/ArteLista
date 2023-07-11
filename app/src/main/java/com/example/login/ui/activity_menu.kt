package com.example.login.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.artelista.model.evento
import com.example.login.R
import com.example.login.databinding.ActivityMenuBinding
import com.example.login.model.artista
import com.example.login.model.galeria
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray
import org.json.JSONObject

class activity_menu : AppCompatActivity() {

private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configurarNavegacion()

        //--- Carga de datos
     /* val jsonArtista= JSONArray("[\n" +
                "            {\n" +
                "                'nombreartista' : 'Armando Jose Agguirre',\n" +
                "                'categoriaartista' : 'Oleo',\n" +
                "                'paisartista' : 'Nicaragua'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'German Traña Obando',\n" +
                "                'categoriaartista' : 'Lapiz',\n" +
                "                'paisartista' : 'Panamá'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Pol Ledent',\n" +
                "                'categoriaartista' : 'Acrilico',\n" +
                "                'paisartista' : 'Ecuador'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Mariber Flores',\n" +
                "                'categoriaartista' : 'Oleo',\n" +
                "                'paisartista' : 'Costa Rica'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Nana Tchelidze',\n" +
                "                'categoriaartista' : 'Canvas',\n" +
                "                'paisartista' : 'Guatemala'\n" +
                "            },\n" +
                "            {\n" +
                "                'nombreartista' : 'Armando Jose Aguirre',\n" +
                "                'categoriaartista' : 'Oleo',\n" +
                "                'paisartista' : 'El Salvador'\n" +
                "            }\n" +
                "        ]")
        val fireDB: FirebaseFirestore = FirebaseFirestore.getInstance()

        for (i in 0 until jsonArtista.length())
        {
            val objArtista = jsonArtista.get(i) as JSONObject
            var Artista = artista()

            Artista.nombreartista = objArtista.getString("nombreartista")
            Artista.categoriaartista = objArtista.getString("categoriaartista")
            Artista.paisartista = objArtista.getString("paisartista")
            fireDB.collection("Artista").document().set(Artista)
        }*/
    }
    protected fun configurarNavegacion()
    {
        val bmenu: BottomNavigationView= binding.navMenuArte
        NavigationUI.setupWithNavController(bmenu, Navigation.findNavController(this,
            R.id.nav_host_fragment_activity_menu
        ))

    }
}