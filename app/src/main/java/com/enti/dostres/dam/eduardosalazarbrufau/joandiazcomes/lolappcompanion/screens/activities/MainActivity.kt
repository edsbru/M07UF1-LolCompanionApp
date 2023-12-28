package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.R
import androidx.fragment.app.commit
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens.LoginScreen

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<LoginScreen>(R.id.mainFragmentContainer)

        }


    }
}