package com.pmdm.peliculas_con

import com.pmdm.pelculas_con_fragmento.R
import com.pmdm.peliculas_con_fragmento.MoviesListFragment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.pmdm.pelculas_con_fragmento.ui.theme.PelículasconfragmentoTheme
import com.pmdm.peliculas_con_fragmento.Movie
import com.pmdm.peliculas_con_fragmento.NewMovieDialogFragment

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fcv = findViewById<FragmentContainerView>(R.id.fragment_container)
        fragmentManager = supportFragmentManager  //gestor de transacciones

        val dialog = NewMovieDialogFragment() { film -> okNewFilm(film)
        }

        /* if (savedInstanceState == null) {
     supportFragmentManager.beginTransaction()
         .replace(R.id.fragment_container, MoviesListFragment())
         .commit()
 }

         */
    }

    private fun okNewFilm(film: Movie) {

    }
}
