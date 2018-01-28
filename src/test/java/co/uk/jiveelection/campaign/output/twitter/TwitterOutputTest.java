package co.uk.jiveelection.campaign.output.twitter;

import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import org.junit.Before;

/**
 * Tests for TwitterOutput.
 */
public class TwitterOutputTest {

    private TwitterOutput twitterOutput;

    @Before
    public void setUp() throws Exception {
        twitterOutput = new TwitterOutput("real_username", new InMemoryJiveTranslator(), "jivebot_token", "jivebot_secret");
    }


}