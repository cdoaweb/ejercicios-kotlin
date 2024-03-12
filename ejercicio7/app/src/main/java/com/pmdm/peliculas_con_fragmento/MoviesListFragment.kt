package com.pmdm.peliculas_con_fragmento

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pmdm.pelculas_con_fragmento.R

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviesListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter
    private var moviesList = mutableListOf<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.moviesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        view.findViewById<FloatingActionButton>(R.id.addMovieFAB).setOnClickListener {
            NewMovieDialogFragment { newMovie ->
                moviesList = mutableListOf(

                    Movie("Título 1", 2021, "Descripción 1", "URL de la imagen 1"),
                    Movie("Título 2", 2022, "Descripción 2", "URL de la imagen 2")
                ).toMutableList()



                moviesList.add(newMovie)
                moviesAdapter.notifyItemInserted(moviesList.size - 1)
            }.show(parentFragmentManager, "newMovieDialog")
        }

        moviesAdapter = MoviesAdapter(moviesList, { position ->
            moviesList.removeAt(position)

            recyclerView.adapter = moviesAdapter
        })

    }
}
