package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.R

class LoginScreen: Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_screen, container, false)

        val loginButton : Button = view.findViewById<Button>(R.id.login_to_config_button)
        loginButton.setOnClickListener{
            val fragment = ConfigScreen()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainActivityContainer, fragment)?.commit()
        }
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}