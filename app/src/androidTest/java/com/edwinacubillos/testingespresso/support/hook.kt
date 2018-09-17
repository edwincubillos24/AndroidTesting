package com.edwinacubillos.testingespresso.support

import android.support.test.espresso.AmbiguousViewMatcherException
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import com.edwinacubillos.testingespresso.R.id.withText
import junit.framework.Assert

fun setTextOnField(id: Int, text: String) {
    Espresso.onView(ViewMatchers.withId(id))
            .perform(ViewActions.replaceText(text))
}

fun wait(seconds: Int) {
    Thread.sleep(seconds.toLong() * 1000)
}

fun isTextDisplayed(text: String) {
    var isDisplayed = true
    Espresso.onView(ViewMatchers.withSubstring(text))
            .withFailureHandler { error, _ ->
                isDisplayed = error is AmbiguousViewMatcherException
            }
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    Assert.assertTrue(isDisplayed)
}

fun isTextDisplayed(text: Int) {
    var isDisplayed = true
    Espresso.onView(ViewMatchers.withText(text))
            .withFailureHandler { error, _ ->
                isDisplayed = error is AmbiguousViewMatcherException
            }
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    Assert.assertTrue(isDisplayed)
}

fun isHintDisplayed(hint: String) {
    var isDisplayed = true
    Espresso.onView(ViewMatchers.withHint(hint))
            .withFailureHandler { error, _ ->
                isDisplayed = error is AmbiguousViewMatcherException
            }
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    Assert.assertTrue(isDisplayed)
}

fun isViewDisplayed(id: Int) {
    Espresso.onView(ViewMatchers.withId(id))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}

fun isViewNotDisplayed(id: Int) {
    var isDisplayed = true
    Espresso.onView(ViewMatchers.withId(id))
            .withFailureHandler { error, _ ->
                isDisplayed = error is NoSuchFieldError
            }
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    Assert.assertFalse(isDisplayed)
}


