package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.R


class ChampionsScreen:  Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.champions_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonChangeToChampionsScreen = view?.findViewById<Button>(R.id.navigation_create_build_button)
        buttonChangeToChampionsScreen?.setOnClickListener {
            changeToChampionsScreen()
        }
    }

    private fun changeToBuildsScreen() {
        val buildsScreen = BuildsScreen()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.mainFragmentContainer, buildsScreen)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun changeToChampionsScreen() {
        val buildsScreen = ChampionsScreen()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.mainFragmentContainer, buildsScreen)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun changeToConfigScreen() {
        val buildsScreen = ConfigScreen()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.mainFragmentContainer, buildsScreen)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}