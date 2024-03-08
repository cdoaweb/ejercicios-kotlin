package com.pmdm.peliculas_con_fragmento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pmdm.pelculas_con_fragmento.R

class MoviesAdapter (
    private val moviesList: MutableList<Movie>,
    private val onMovieDelete: (position: Int) -> Unit ): RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.movieTitle)
        val year: TextView = view.findViewById(R.id.movieYear)
        val description: TextView = view.findViewById(R.id.movieDescription)
        val image: ImageView = view.findViewById(R.id.movieImage)
        val deleteButton: Button = view.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = moviesList.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.title
        holder.year.text = movie.year.toString()
        holder.description.text = movie.description
        Glide.with(holder.image.context).load(movie.imageUrl).into(holder.image)
        holder.deleteButton
        {
            onMovieDelete(position)
            notifyItemRemoved(position)
        }
    }


}