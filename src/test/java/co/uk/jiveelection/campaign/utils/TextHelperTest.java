/**
 *
 */
package co.uk.jiveelection.campaign.utils;

import co.uk.jiveelection.campaign.jive.web.TextHelper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TextHelperTest {

    private static final int TWEET_LIMIT = 280;
    private String seedString;

    @Before
    public void setUp() throws Exception {
        seedString = StringUtils.repeat("n", TWEET_LIMIT);
    }

    /**
     * Test method for {@link TextHelper#twitterWorkarounds(String)}.
     */
    @Test
    public void shouldTrimString() {
        final String testString = seedString + " ";
        assertThat("String not trimmed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString)));
    }

    @Test
    public void shouldRemove_RT() {
        final String testString = "RT" + seedString;
        assertThat("String: 'RT' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString)));
    }

    @Test
    public void shouldRemove_Backslash() {
        final String testString = seedString + "\"";
        assertThat("String: '\"' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString)));
    }

    @Test
    public void shouldRemove_QuestionMark() {
        final String testString = seedString + "?";
        assertThat("String: '?' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString)));
    }

    @Test
    public void shouldRemove_WhatItIsMama() {
        final String testString = seedString + "What it is, Mama! ";
        assertThat("String: 'What it is, Mama! ' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString)));
    }

    @Test
    public void shouldRemove_SlapMahFro() {
        final String testString = seedString + " Slap mah fro!";
        assertThat("String: ' Slap mah fro!' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString)));
    }

    @Test
    public void shouldReplace_Candun() {
        final String testString = seedString + "candun ";
        assertThat("String: 'candun ' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "candid")));
    }

    @Test
    public void shouldReplace_Children() {
        final String testString = seedString + "children";
        assertThat("String: 'children' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "kidz")));
    }

    @Test
    public void shouldReplace_Child() {
        final String testString = seedString + "child";
        assertThat("String: 'child' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "kid")));
    }

    @Test
    public void shouldReplace_DotSpaceAt() {
        final String testString = seedString + ". @";
        assertThat("String: '. @ ' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + ".@")));
    }

    @Test
    public void shouldReplace_KindunDidate() {
        final String testString = seedString + "kindun didate";
        assertThat("String: 'kindun didate' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "candidate")));

    }

    @Test
    public void shouldReplace_SSnatch() {
        final String testString = seedString + "s snatch";
        assertThat("String: 's snatch' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "stake")));

    }

    @Test
    public void shouldReplace_Some() {
        final String testString = seedString + "some";
        assertThat("String: 'some' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "per")));

    }

    @Test
    public void shouldReplace_Down() {
        final String testString = seedString + "down";
        assertThat("String: 'down' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "up")));

    }

    @Test
    public void shouldReplace_Boogy() {
        final String testString = seedString + "boogy";
        assertThat("String: 'boogy' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "danz")));
    }

    @Test
    public void shouldReplace_Per() {
        final String testString = seedString + " per";
        assertThat("String: ' per' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + " a")));
    }

    @Test
    public void shouldReplace_Powerful() {
        final String testString = seedString + "powerful";
        assertThat("String: 'powerful' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "hench")));
    }

    @Test
    public void shouldReplace_Were() {
        final String testString = seedString + "we're";
        assertThat("String: 'we're' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "we")));
    }

    @Test
    public void shouldReplace_Isnt() {
        final String testString = seedString + "isn't";
        assertThat("String: 'isn't' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "ain't")));
    }

    @Test
    public void shouldReplace_Finances() {
        final String testString = seedString + "finances";
        assertThat("String: 'finances' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(seedString + "monies")));
    }

}
