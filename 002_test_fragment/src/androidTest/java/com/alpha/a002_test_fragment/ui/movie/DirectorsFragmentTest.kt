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

class DirectorsFragmentTest {
    @Test
    fun test_isDirectorsListVisible() {
        // SETUP
        val directors = arrayListOf("R.J. Stewart", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle().apply {
            putStringArrayList("args_directors", directors)
        }

        val scenario = launchFragmentInContainer<DirectorsFragment>(fragmentArgs = bundle, factory = fragmentFactory)

        // Verify
        onView(withId(R.id.directors_text))
            .check(matches(withText(DirectorsFragment.stringBuilderForDirectors(directors))))

    }
}