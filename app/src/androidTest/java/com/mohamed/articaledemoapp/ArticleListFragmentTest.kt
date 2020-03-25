package com.mohamed.articaledemoapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mohamed.articaledemoapp.ui.main.ui.main.view.ArticleAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ArticleListFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testListVisibility(){
        onView(withId(R.id.rv_articles)).check(matches(isDisplayed()))
    }

    @Test
    fun testListSelectedItemAndDisplayDetailsFragment(){
        onView(withId(R.id.rv_articles)).perform(RecyclerViewActions.actionOnItemAtPosition<ArticleAdapter.ArticleViewHolder>(0,click()))

//        onView(withId(R.id.tv_title)).check(matches(withText("")))
    }

}