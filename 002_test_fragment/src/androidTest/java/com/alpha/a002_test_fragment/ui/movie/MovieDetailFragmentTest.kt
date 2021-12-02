package com.alpha.a002_test_fragment.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.alpha.a002_test_fragment.R
import com.alpha.a002_test_fragment.data.DummyMovies.THE_RUNDOWN
import com.alpha.a002_test_fragment.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest{

    @Before
    fun initTest(){
        val fragmentFactory = MovieFragmentFactory()
        val movie = THE_RUNDOWN
        val bundle = Bundle().apply {
            putInt("movie_id", movie.id)
        }

        launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
    }

    @Test
    fun test_isMovieDataVisible() {
        onView(withId(R.id.movie_title)).check(matches(withText(THE_RUNDOWN.title)))
        onView(withId(R.id.movie_description)).check(matches(withText(THE_RUNDOWN.description)))
    }
}