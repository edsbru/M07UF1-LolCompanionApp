package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.R

class BuildsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.builds_screen)

        val tituloBuilds = findViewById<TextView>(R.id.tituloBuilds)
        val editTextBuilds = findViewById<EditText>(R.id.editTextBuilds)

        // Configuración del título
        tituloBuilds.text = "Builds"
    }
}