package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.R
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.android.gms.common.SignInButton
import com.google.android.material.button.MaterialButton

class LoginScreen: Fragment() {

    lateinit var fragmentView: View

    val googleAuthButton by lazy { fragmentView.findViewById<SignInButton>(R.id.login_google_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.login_screen, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        googleAuthButton.setOnClickListener{ googleAuth() }


        var buttonNext = fragmentView.findViewById<MaterialButton>(R.id.login_button)

        buttonNext.setOnClickListener{

            val fragment = ChampionsScreen()

            val manager = activity?.supportFragmentManager

            val transaction = manager?.beginTransaction()

            transaction?.replace(R.id.mainFragmentContainer, fragment)
            transaction?.addToBackStack(null)
            transaction?.commit()




        }

    }

    private fun googleAuth(){
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
        )

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()

    }


}