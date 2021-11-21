package com.alpha.a002_test_fragment.data.source

import com.alpha.a002_test_fragment.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}