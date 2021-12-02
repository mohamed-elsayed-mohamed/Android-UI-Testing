package com.alpha.a002_test_fragment.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alpha.a002_test_fragment.R
import com.alpha.a002_test_fragment.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test

class StarActorsFragmentTest {
    @Test
    fun test_isStarActorsListVisible() {
        // SETUP
        val starActors = arrayListOf(
            "Dwayne Johnson",
            "Seann William Scott",
            "Rosario Dawson",
            "Christopher Walken"
        )
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle().apply {
            putStringArrayList("args_actors", starActors)
        }

        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        // Verify
        onView(withId(R.id.star_actors_title))
            .check(
                matches(
                    withText(
                        StarActorsFragment.stringBuilderForStarActors(
                            starActors
                        )
                    )
                )
            )

    }
}