package co.uk.jiveelection.campaign.output.twitter

import co.uk.jiveelection.campaign.jive.Jive
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import twitter4j.Twitter
import twitter4j.TwitterException

/**
 * Unit Tests for TwitterOutput
 */
@RunWith(MockitoJUnitRunner::class)
class TwitterOutputTest {

    @Mock
    private lateinit var mockJiveBot: Jive<*, *, *>

    @Mock
    private lateinit var mockTwitter: Twitter

    private lateinit var twitterOutput: TwitterOutput

    @Before
    fun setUp() {
        twitterOutput = TwitterOutput(mockJiveBot, mockTwitter)
    }

    @Test
    fun should_CallJiveComplete_When_OutputCompletes() {
        // Given

        val status = TestStatus(text = "tweet tweet")

        // When
        twitterOutput.onOutputComplete(status)

        // Then
        verify(mockJiveBot).onJiveComplete(status)
    }

    @Test
    @Throws(TwitterException::class)
    fun should_UpdateStatus_When_OutputJiveCalled() {
        // Given
        val jive = "jive"
        val status = TestStatus(text = jive)
        whenever(mockTwitter.updateStatus(jive)).thenReturn(status)

        // When
        twitterOutput.outputJive(jive)

        // Then
        verify(mockJiveBot).onJiveComplete(status)
    }

    @Test
    @Throws(TwitterException::class)
    fun should_UpdateStatusTwice_When_OutputJiveCalledWithJiveOverTweetLimit() {
        // Given
        // 281 characters
        val jive = "jivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejive jivejivejivejivejive"
        val tweet1 = "jivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejive [1/2]"
        val tweet2 = "jivejivejivejivejive [2/2]"
        val status1 = TestStatus(text = tweet1)
        val status2 = TestStatus(text = tweet2)
        whenever(mockTwitter.updateStatus(tweet1)).thenReturn(status1)
        whenever(mockTwitter.updateStatus(tweet2)).thenReturn(status2)

        val inOrder = inOrder(mockJiveBot)

        // When
        twitterOutput.outputJive(jive)

        // Then
        inOrder.verify(mockJiveBot).onJiveComplete(status1)
        inOrder.verify(mockJiveBot).onJiveComplete(status2)
    }

    @Test
    @Throws(TwitterException::class)
    fun should_Not_UpdateStatus_When_OutputJiveCalledWithJiveOverTweetLimitUnableToBePaginated() {
        // Given
        // 281 characters
        val jive = "jivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejivejive"

        // When
        twitterOutput.outputJive(jive)

        // Then
        verify(mockTwitter, never()).updateStatus(anyString())
    }
}