/**
 *
 */
package co.uk.jiveelection.campaign.utils

import co.uk.jiveelection.campaign.translator.web.TextHelper
import org.apache.commons.lang3.StringUtils
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class TextHelperTest {
    private val seedString: String = StringUtils.repeat("n", TWEET_LIMIT)

    /**
     * Test method for [TextHelper.twitterWorkarounds].
     */
    @Test
    fun shouldTrimString() {
        val testString = "$seedString "
        assertThat("String not trimmed as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo<String>(seedString)))
    }

    @Test
    fun shouldRemove_RT() {
        val testString = "RT$seedString"
        assertThat("String: 'RT' not removed as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo<String>(seedString)))
    }

    @Test
    fun shouldRemove_Backslash() {
        val testString = "$seedString\""
        assertThat("String: '\"' not removed as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo<String>(seedString)))
    }

    @Test
    fun shouldRemove_QuestionMark() {
        val testString = "$seedString?"
        assertThat("String: '?' not removed as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo<String>(seedString)))
    }

    @Test
    fun shouldRemove_WhatItIsMama() {
        val testString = seedString + "What it is, Mama! "
        assertThat("String: 'What it is, Mama! ' not removed as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo<String>(seedString)))
    }

    @Test
    fun shouldRemove_SlapMahFro() {
        val testString = "$seedString Slap mah fro!"
        assertThat("String: ' Slap mah fro!' not removed as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo<String>(seedString)))
    }

    @Test
    fun shouldReplace_Candun() {
        val testString = seedString + "candun "
        assertThat("String: 'candun ' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "candid")))
    }

    @Test
    fun shouldReplace_Children() {
        val testString = seedString + "children"
        assertThat("String: 'children' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "kidz")))
    }

    @Test
    fun shouldReplace_Child() {
        val testString = seedString + "child"
        assertThat("String: 'child' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "kid")))
    }

    @Test
    fun shouldReplace_DotSpaceAt() {
        val testString = "$seedString. @"
        assertThat("String: '. @ ' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo("$seedString.@")))
    }

    @Test
    fun shouldReplace_KindunDidate() {
        val testString = seedString + "kindun didate"
        assertThat("String: 'kindun didate' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "candidate")))

    }

    @Test
    fun shouldReplace_SSnatch() {
        val testString = seedString + "s snatch"
        assertThat("String: 's snatch' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "stake")))

    }

    @Test
    fun shouldReplace_Some() {
        val testString = seedString + "some"
        assertThat("String: 'some' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "per")))

    }

    @Test
    fun shouldReplace_Down() {
        val testString = seedString + "down"
        assertThat("String: 'down' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "up")))

    }

    @Test
    fun shouldReplace_Boogy() {
        val testString = seedString + "boogy"
        assertThat("String: 'boogy' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "danz")))
    }

    @Test
    fun shouldReplace_Per() {
        val testString = "$seedString per"
        assertThat("String: ' per' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo("$seedString a")))
    }

    @Test
    fun shouldReplace_Powerful() {
        val testString = seedString + "powerful"
        assertThat("String: 'powerful' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "hench")))
    }

    @Test
    fun shouldReplace_Were() {
        val testString = seedString + "we're"
        assertThat("String: 'we're' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "we")))
    }

    @Test
    fun shouldReplace_Isnt() {
        val testString = seedString + "isn't"
        assertThat("String: 'isn't' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "ain't")))
    }

    @Test
    fun shouldReplace_Finances() {
        val testString = seedString + "finances"
        assertThat("String: 'finances' not replaced as expected", TextHelper.twitterWorkarounds(testString), `is`(equalTo(seedString + "monies")))
    }

    companion object {
        private const val TWEET_LIMIT = 280
    }

}
