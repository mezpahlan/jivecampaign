/**
 *
 */
package co.uk.jiveelection.campaign.utils;

import co.uk.jiveelection.campaign.jive.web.TextHelper;
import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TextHelperTest {
    // 140 character string
    private static final String TWEET_LIMIT = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    private String testString;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link TextHelper#twitterWorkarounds(String)}.
     */
    @Test
    public void shouldTrimString() {
        testString = TWEET_LIMIT + " ";
        assertThat("String not trimmed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT)));
    }

    @Test
    public void shouldProcessRemovals() {
        testString = "RT" + TWEET_LIMIT;
        assertThat("String: 'RT' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT)));

        testString = TWEET_LIMIT + "\"";
        assertThat("String: '\"' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT)));

        testString = TWEET_LIMIT + "?";
        assertThat("String: '?' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT)));

        testString = TWEET_LIMIT + "What it is, Mama! ";
        assertThat("String: 'What it is, Mama! ' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT)));

        testString = TWEET_LIMIT + " Slap mah fro!";
        assertThat("String: ' Slap mah fro!' not removed as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT)));
    }

    @Test
    public void shouldProcessReplacements() {
        testString = TWEET_LIMIT + "candun ";
        assertThat("String: 'candun ' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "candid")));
        testString = TWEET_LIMIT + "children";
        assertThat("String: 'children' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "kidz")));
        testString = TWEET_LIMIT + "child";
        assertThat("String: 'child' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "kid")));
        testString = TWEET_LIMIT + ". @";
        assertThat("String: '. @ ' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + ".@")));
        testString = TWEET_LIMIT + "kindun didate";
        assertThat("String: 'kindun didate' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "candidate")));
        testString = TWEET_LIMIT + "s snatch";
        assertThat("String: 's snatch' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "stake")));
        testString = TWEET_LIMIT + "some";
        assertThat("String: 'some' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "per")));
        testString = TWEET_LIMIT + "down";
        assertThat("String: 'down' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "up")));
        testString = TWEET_LIMIT + "boogy";
        assertThat("String: 'boogy' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "danz")));
        testString = TWEET_LIMIT + " per";
        assertThat("String: ' per' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + " a")));
        testString = TWEET_LIMIT + "powerful";
        assertThat("String: 'powerful' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "hench")));
        testString = TWEET_LIMIT + "we're";
        assertThat("String: 'we're' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "we")));
        testString = TWEET_LIMIT + "isn't";
        assertThat("String: 'isn't' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "ain't")));
        testString = TWEET_LIMIT + "finances";
        assertThat("String: 'finances' not replaced as expected", TextHelper.twitterWorkarounds(testString), is(equalTo(TWEET_LIMIT + "monies")));
    }

}
