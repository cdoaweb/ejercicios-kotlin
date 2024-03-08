package com.pmdm.peliculas_con_login

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var moviesRecyclerView: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter
    private var moviesList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesList = listOf(
            Movie("Título 1", 2021, "Descripción 1", "URL de la imagen 1"),
            Movie("Título 2", 2022, "Descripción 2", "URL de la imagen 2")
        ).toMutableList()

        moviesRecyclerView = findViewById(R.id.moviesRecyclerView)
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        moviesAdapter = MoviesAdapter(moviesList, { position ->
            moviesList.removeAt(position)
        })
        moviesRecyclerView.adapter = moviesAdapter

        moviesList.forEach {
            Log.d("MovieApp", "Película: ${it.title}, Año: ${it.year}")
        }
    }
}
