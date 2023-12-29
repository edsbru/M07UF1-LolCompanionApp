package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.R

class UploadScreen : AppCompatActivity() {

    private var selectedImageUri: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_screen)

        val btnPickImage = findViewById<Button>(R.id.btnPickImage)

        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->

            selectedImageUri = uri.toString()

        }

        btnPickImage.setOnClickListener {
            // Open the image picker
            getContent.launch("image/*")
        }
    }
}


