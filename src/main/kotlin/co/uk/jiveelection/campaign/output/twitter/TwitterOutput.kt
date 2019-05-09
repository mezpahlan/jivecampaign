package co.uk.jiveelection.campaign.output.twitter

import co.uk.jiveelection.campaign.jive.Jive
import co.uk.jiveelection.campaign.output.Output
import com.google.auto.factory.AutoFactory
import com.google.auto.factory.Provided
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import twitter4j.Status
import twitter4j.Twitter

/**
 * Configures a Twitter user to tweet on behalf of.
 */
@AutoFactory
class TwitterOutput(private val jiveBot: Jive<*, *, *>, @Provided private val twitter: Twitter) : Output<Status> {

    private val logger: Logger = LoggerFactory.getLogger(TwitterOutput::class.java)

    override fun outputJive(jive: String) {
        // Tweet, xzibit style
        // Check if translator is > tweet character limit
        // if yes break into smaller tweet with [1/2], [2,2] suffix
        // if not tweet
        if (jive.length > TWEET_CHARACTER_LIMIT) {
            val i = jive.lastIndexOf(" ", TWEET_PAGINATION_INDEX)

            if (i != -1) {
                val first = jive.substring(0, i) + " [1/2]"
                val second = jive.substring(i + 1) + " [2/2]"

                onOutputComplete(tweet(first))
                onOutputComplete(tweet(second))
            }
        } else {
            onOutputComplete(tweet(jive))
        }
    }

    override fun onOutputComplete(status: Status) {
        jiveBot.onJiveComplete(status)
        logger.info("Sent jive status from: ${twitter.screenName}")
    }

    private fun tweet(jive: String): Status {
        return twitter.updateStatus(jive)
    }

    companion object {
        private const val TWEET_CHARACTER_LIMIT = 280
        private const val TWEET_PAGINATION_INDEX = 265
    }
}
