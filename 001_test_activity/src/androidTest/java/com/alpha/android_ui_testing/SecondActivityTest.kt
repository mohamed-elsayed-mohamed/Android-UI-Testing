package com.alpha.android_ui_testing

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun test_isActivityInView() {
        Espresso.onView(ViewMatchers.withId(R.id.secondary))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_visibility_title_backButton() {
        Espresso.onView(ViewMatchers.withId(R.id.activity_secondary_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.button_back))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_isTitleTextDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.activity_secondary_title))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.text_secondaryactivity)))
    }
}