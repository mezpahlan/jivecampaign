package co.uk.jiveelection.campaign.output.twitter;

import co.uk.jiveelection.campaign.jive.Jive;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import static org.mockito.Mockito.verify;

/**
 * Unit Tests for TwitterOutput
 */
@RunWith(MockitoJUnitRunner.class)
public class TwitterOutputTest {

    @Mock
    Jive mockJiveBot;

    @Mock
    Twitter mockTwitter;

    private TwitterOutput twitterOutput;

    @Before
    public void setUp() {
        twitterOutput = new TwitterOutput(mockJiveBot, "jivebot_token", "jivebot_token_secret");
    }

    @Test
    public void should_CallJiveComplete_When_OutputCompletes() {
        // Given
        final Status status = new StatusBuilder()
                .text("tweet tweet")
                .build();

        // When
        twitterOutput.onOutputComplete(status);

        // Then
        verify(mockJiveBot).onJiveComplete(status);
    }

    @Test
    @Ignore
    public void should_UpdateStatus_When_OutputJiveCalled() throws TwitterException {
        // Given
        final String jive = "jive";

        // When
        twitterOutput.outputJive(jive);

        // Then
        verify(mockTwitter).updateStatus(jive);
        // TODO: collaborate with the Twitter object and verify
    }
}