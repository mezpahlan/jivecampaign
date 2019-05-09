package co.uk.jiveelection.campaign.input.twitter

import co.uk.jiveelection.campaign.input.Input
import co.uk.jiveelection.campaign.jive.Jive
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity
import com.google.auto.factory.AutoFactory
import com.google.auto.factory.Provided
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import twitter4j.*
import java.util.*

/**
 * Configures a Twitter user and listens to a tweet timeline.
 *
 *
 * Does not follow retweets.
 */
@AutoFactory
class TwitterInput(private val jiveBot: Jive<*, *, *>, @Provided private val realUserName: String, @Provided private val twitter: Twitter, @Provided private val twitterStream: TwitterStream) : Input<Status> {

    private val logger: Logger = LoggerFactory.getLogger(TwitterInput::class.java)

    @Throws(TwitterException::class)
    fun init() {
        val realId = twitter.showUser(realUserName).id

        val tweetFilterQuery = FilterQuery()
        tweetFilterQuery.follow(realId)

        twitterStream
                .onStatus { status ->
                    if (status.user.id == realId) {
                        if (!status.isRetweet) {
                            logger.info("Received status from: $realUserName.")
                            val translationEntities = extractEntities(status)
                            jiveBot.onInputReceived(translationEntities)
                        }
                    }
                }
                .filter(tweetFilterQuery)
    }

    override fun extractEntities(input: Status): List<TranslationEntity> {
        // Original status length
        val text = input.text
        val length = text.length

        // Begin entity extract
        val verbatimEntities = ArrayList<TranslationEntity>()
        val entities = ArrayList<TranslationEntity>()

        // Get URL Entities
        for (i in 0 until input.urlEntities.size) {
            val urlEntities = input.urlEntities[i]
            val start = urlEntities.start
            val end = urlEntities.end
            verbatimEntities.add(TranslationEntity.verbatim(start, end, text.substring(start, end)))
        }

        // Get Media Entities
        for (i in 0 until input.mediaEntities.size) {
            val mediaEntities = input.mediaEntities[i]
            val start = mediaEntities.start
            val end = mediaEntities.end
            verbatimEntities.add(TranslationEntity.verbatim(start, end, text.substring(start, end)))
        }

        // Get UserMentionEntity if they exists
        for (i in 0 until input.userMentionEntities.size) {
            val userMentionEntities = input.userMentionEntities[i]
            val start = userMentionEntities.start
            val end = userMentionEntities.end
            verbatimEntities.add(TranslationEntity.verbatim(start, end, text.substring(start, end)))
        }

        // Get HashtagEntity if they exists
        for (i in 0 until input.hashtagEntities.size) {
            val hashTagEntities = input.hashtagEntities[i]
            val start = hashTagEntities.start
            val end = hashTagEntities.end
            verbatimEntities.add(TranslationEntity.verbatim(start, end, text.substring(start, end)))
        }

        // Order verbatim entities by start position
        verbatimEntities.sortWith(Comparator.comparingInt { it.start })

        // Add translatable entities
        var position = 0
        for (verbatimEntity in verbatimEntities) {
            if (verbatimEntity.start != 0) {
                entities.add(TranslationEntity.translate(position, verbatimEntity.start, text.substring(position, verbatimEntity.start)))
            }
            entities.add(verbatimEntity)
            position = verbatimEntity.end
        }

        // Collect the rest of the string to translate
        if (position < length) {
            entities.add(TranslationEntity.translate(position, length, text.substring(position, length)))
        }

        // Order all entities by start position
        entities.sortWith(Comparator.comparingInt { it.start })

        return entities
    }
}
