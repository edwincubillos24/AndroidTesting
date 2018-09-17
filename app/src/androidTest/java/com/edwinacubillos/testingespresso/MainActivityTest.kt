package com.edwinacubillos.testingespresso

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.edwinacubillos.testingespresso.support.*

import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    //we need the rule to launch the activity before running the test
    @Rule
    @JvmField
    var myRule = ActivityTestRule<EspressoTestActivity>(EspressoTestActivity::class.java) //this line means: please espresso launch the EspressoTestActivity before running the test

    @Test
    fun bRegisterClicked() {
        isViewNotDisplayed(R.id.tError)
        onView(withId(R.id.eName)).perform(clearText())
        onView(withId(R.id.bRegister)).perform(click())
        isViewDisplayed(R.id.tError)
        onView(withId(R.id.tError)).check(matches(withText(R.string.error_text)))
    }

    @Test
    fun registerWithoutName() {
        isViewNotDisplayed(R.id.tError)
        onView(withId(R.id.eName)).check(matches(withText("")))
        onView(withId(R.id.bRegister)).perform(click())
        isViewDisplayed(R.id.tError)
        onView(withId(R.id.tError)).check(matches(withText(R.string.error_text)))
    }

    @Test
    fun registerWithOutPassword() {
        isViewNotDisplayed(R.id.tError)
        onView(withId(R.id.ePassword)).check(matches(withText("")))
        onView(withId(R.id.bRegister)).perform(click())
        isViewDisplayed(R.id.tError)
        onView(withId(R.id.tError)).check(matches(withText(R.string.error_text)))
    }

    @Test
    fun registerWithOutUsername() {
        isViewNotDisplayed(R.id.tError)
        setTextOnField(R.id.eName, "Edwin")
        setTextOnField(R.id.ePassword, "1234")
        onView(withId(R.id.bRegister)).perform(click())
        isViewDisplayed(R.id.tError)
        onView(withId(R.id.tError)).check(matches(withText(R.string.error_text)))
    }

    @Test
    fun registerSuccessfull() {
        isViewNotDisplayed(R.id.tError)
        setTextOnField(R.id.eName, "Edwin")
        setTextOnField(R.id.eUsername, "edwinacubillos")
        setTextOnField(R.id.ePassword, "1234")
        onView(withId(R.id.bRegister)).perform(click())
        isTextDisplayed("New account has created")
    }
}