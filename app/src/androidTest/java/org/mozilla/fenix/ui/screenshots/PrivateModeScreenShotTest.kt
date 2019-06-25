/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.ui.screenshots

import androidx.test.rule.ActivityTestRule

import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.mozilla.fenix.HomeActivity
import org.mozilla.fenix.R
import org.mozilla.fenix.helpers.HomeActivityTestRule

import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.locale.LocaleTestRule

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf

class PrivateModeScreenShotTest : ScreenshotTest() {
    @Rule @JvmField
    val localeTestRule = LocaleTestRule()
    @get:Rule
    var mActivityTestRule: ActivityTestRule<HomeActivity> = HomeActivityTestRule()

    @After
    fun tearDown() {
        mActivityTestRule.getActivity().finishAndRemoveTask()
    }

    @Test
    fun privateBrowsingMainScreen() {
        onView(allOf(withId(R.id.privateBrowsingButton))).perform(click())
        Screengrab.screenshot("private-browsing-menu")
        onView(allOf(withId(R.id.privateBrowsingButton))).perform(click())
    }
}
