package com.pmdm.peliculas_con_fragmento

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.pmdm.pelculas_con_fragmento.R

class NewMovieDialogFragment(private val onNewFilm: (Movie) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = MaterialAlertDialogBuilder(it)
            val inflater = it.layoutInflater
            val view = inflater.inflate(R.layout.dialog_new_movie, null)

            val titleEditText = view.findViewById<EditText>(R.id.titleEditText)
            val yearEditText = view.findViewById<EditText>(R.id.yearEditText)
            val descriptionEditText = view.findViewById<EditText>(R.id.descriptionEditText)
            val imageUrlEditText = view.findViewById<EditText>(R.id.imageUrlEditText)

            builder.setView(view)
                .setTitle("New Movie")
                .setPositiveButton("Add") { dialog, id ->
                    val title = titleEditText.text.toString()
                    val year = yearEditText.text.toString().toIntOrNull() ?: 0
                    val description = descriptionEditText.text.toString()
                    val imageUrl = imageUrlEditText.text.toString()
                    val movie = Movie(title, year, description, imageUrl)
                    onNewFilm(movie)
                }
                .setNegativeButton("Cancel") { dialog, id ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}