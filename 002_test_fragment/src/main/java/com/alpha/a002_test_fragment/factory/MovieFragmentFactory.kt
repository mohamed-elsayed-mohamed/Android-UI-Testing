package com.alpha.a002_test_fragment.factory

import androidx.fragment.app.FragmentFactory
import com.alpha.a002_test_fragment.ui.movie.DirectorsFragment
import com.alpha.a002_test_fragment.ui.movie.MovieDetailFragment
import com.alpha.a002_test_fragment.ui.movie.StarActorsFragment

class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className) {

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}













