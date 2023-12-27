package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.R

class ConfiguracionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.config_screen)

        val tituloConfiguracion = findViewById<TextView>(R.id.tituloConfiguracion)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Configuración del título
        tituloConfiguracion.text = "Settings"

        // Configuración del botón de logout
        btnLogout.setOnClickListener {
            // Realizar las operaciones de logout aquí
            // Por ejemplo, redirigir a la pantalla de inicio de sesión
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)

            /* Cierra la actividad actual */
            finish()
        }
    }
}