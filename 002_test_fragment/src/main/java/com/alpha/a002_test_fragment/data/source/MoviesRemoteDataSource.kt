package com.alpha.a002_test_fragment.data.source

import com.alpha.a002_test_fragment.data.DummyMovies.INFINITY_WAR
import com.alpha.a002_test_fragment.data.DummyMovies.THE_RUNDOWN
import com.alpha.a002_test_fragment.data.Movie

object MoviesRemoteDataSource: MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(2)

    init {
        addMovie(INFINITY_WAR)
        addMovie(THE_RUNDOWN)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA.get(movieId)
    }

    private fun addMovie(movie: Movie){
        MOVIES_REMOTE_DATA[movie.id] = movie
    }
}














