package com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.screens

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.enti.dostres.dam.eduardosalazarbrufau.joandiazcomes.lolappcompanion.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.net.URI
import java.util.UUID


class ChampionsScreen:  Fragment() {

    companion object {
        private const val PICK_IMAGE_REQUEST = 71
    }
    private lateinit var storage: FirebaseStorage
    private lateinit var storageReference: StorageReference
    private lateinit var imagePreview: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.champions_screen, container, false)

        val selectImageButton = view.findViewById<Button>(R.id.select_image_button)
        imagePreview = view.findViewById(R.id.selected_image)

        storage = FirebaseStorage.getInstance()
        storageReference = storage.reference

        selectImageButton.setOnClickListener {
            selectImage()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonChangeToBuildsScreen = view?.findViewById<Button>(R.id.navigation_builds_button)
        val buttonChangeToChampionsScreen = view?.findViewById<Button>(R.id.navigation_create_build_button)
        val buttonChangeToConfigScreen = view?.findViewById<Button>(R.id.navigation_settings_button)

        buttonChangeToBuildsScreen?.setOnClickListener {
            changeToBuildsScreen()
        }
        buttonChangeToChampionsScreen?.setOnClickListener {
            changeToChampionsScreen()
        }
        buttonChangeToConfigScreen?.setOnClickListener {
            changeToConfigScreen()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            // Obtener la URI de la imagen seleccionada
            val filePath = data.data

            // Mostrar la vista previa de la imagen seleccionada
            imagePreview.visibility = View.VISIBLE
            imagePreview.setImageURI(filePath)

            // Subir la imagen a Firebase Storage
            if (filePath != null) {
                uploadImage(filePath)
            }
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
        val championsScreen = ChampionsScreen()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.mainFragmentContainer, championsScreen)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun changeToConfigScreen() {
        val configScreen = ConfigScreen()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.mainFragmentContainer, configScreen)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun selectImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    private fun uploadImage(filePath: Uri){
        // Crear una referencia al lugar en Firebase Storage donde se almacenará la imagen
        val storageRef = storageReference.child("images/${UUID.randomUUID()}")

        // Iniciar la carga de la imagen
        val uploadTask = storageRef.putFile(filePath)

        // Continuar con la tarea después de que la carga esté completa
        uploadTask.continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            storageRef.downloadUrl
        }
    }
}
