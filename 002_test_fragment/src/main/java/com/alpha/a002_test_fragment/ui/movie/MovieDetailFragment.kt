package com.alpha.a002_test_fragment.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alpha.a002_test_fragment.R
import com.alpha.a002_test_fragment.data.Movie
import com.alpha.a002_test_fragment.data.source.MoviesRemoteDataSource
import com.alpha.a002_test_fragment.databinding.FragmentMovieDetailBinding
import com.bumptech.glide.Glide

class MovieDetailFragment : Fragment(){

    private val binding: FragmentMovieDetailBinding by lazy { FragmentMovieDetailBinding.inflate(layoutInflater) }
    private lateinit var movie: Movie

    /**
     * In production the MoviesRemoteDataSource would be either:
     * 1) Be injected with a DI framework like dagger
     * 2) Be passed as a constructor param to the Fragment (if using FragmentFactory)
     * This is a simple use case so I'm just writing it here.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getInt("movie_id").let{ movieId ->
                MoviesRemoteDataSource.getMovie(movieId)?.let{ movieFromRemote ->
                    movie = movieFromRemote
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMovieDetails()

        binding.movieDirectiors.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_directors", movie.directors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DirectorsFragment::class.java, bundle)
                ?.addToBackStack("DirectorsFragment")
                ?.commit()
        }

        binding.movieStarActors.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_actors", movie.star_actors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, StarActorsFragment::class.java, bundle)
                ?.addToBackStack("StarActorsFragment")
                ?.commit()
        }
    }

    private fun setMovieDetails(){
        movie.let{ nonNullMovie ->
            Glide.with(this)
                .load(nonNullMovie.image)
                .into(binding.movieImage)
            binding.movieTitle.text = nonNullMovie.title
            binding.movieDescription.text = nonNullMovie.description
        }
    }

}

















