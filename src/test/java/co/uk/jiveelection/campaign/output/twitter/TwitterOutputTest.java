package co.uk.jiveelection.campaign.output.twitter;

import co.uk.jiveelection.campaign.jive.Jive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Unit Tests for TwitterOutput
 */
@RunWith(MockitoJUnitRunner.class)
public class TwitterOutputTest {

    @Mock
    private Jive mockJiveBot;

    @Mock
    private Twitter mockTwitter;

    private TwitterOutput twitterOutput;

    @Before
    public void setUp() {
        twitterOutput = new TwitterOutput(mockJiveBot, mockTwitter);
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
    public void should_UpdateStatus_When_OutputJiveCalled() throws TwitterException {
        // Given
        final String jive = "jive";

        // When
        twitterOutput.outputJive(jive);

        // Then
        verify(mockTwitter).updateStatus(jive);
    }

    @Test
    public void should_UpdateStatusTwice_When_OutputJiveCalledWithJiveOverTweetLimit() throws TwitterException {
        // Given
        // 281 characters
        final String jive = "jivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejive jivejivejivejivejive";
        final String tweet1 = "jivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejive [1/2]";
        final String tweet2 = "jivejivejivejivejive [2/2]";

        final InOrder inOrder = inOrder(mockTwitter);

        // When
        twitterOutput.outputJive(jive);

        // Then
        inOrder.verify(mockTwitter).updateStatus(tweet1);
        inOrder.verify(mockTwitter).updateStatus(tweet2);
    }

    @Test
    public void should_Not_UpdateStatus_When_OutputJiveCalledWithJiveOverTweetLimitUnableToBePaginated() throws TwitterException {
        // Given
        // 281 characters
        final String jive = "jivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejive";

        // When
        twitterOutput.outputJive(jive);

        // Then
        verify(mockTwitter, never()).updateStatus(anyString());
    }
}