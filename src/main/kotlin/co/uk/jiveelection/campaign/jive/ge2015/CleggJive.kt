package co.uk.jiveelection.campaign.jive.ge2015

import co.uk.jiveelection.campaign.input.twitter.TwitterInput
import co.uk.jiveelection.campaign.input.twitter.TwitterInputFactory
import co.uk.jiveelection.campaign.jive.Jive
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput
import co.uk.jiveelection.campaign.output.twitter.TwitterOutputFactory
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslatorFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import twitter4j.TwitterException

import javax.inject.Inject

class CleggJive @Inject
constructor(
        twitterInputFactory: TwitterInputFactory,
        twitterOutputFactory: TwitterOutputFactory,
        inMemoryJiveTranslatorFactory: InMemoryJiveTranslatorFactory
) : Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator>() {

    private val logger: Logger = LoggerFactory.getLogger(CleggJive::class.java)

    override val input: TwitterInput = twitterInputFactory.create(this)
    override val output: TwitterOutput = twitterOutputFactory.create(this)
    override val translator: InMemoryJiveTranslator = inMemoryJiveTranslatorFactory.create(this)

    @Throws(TwitterException::class)
    override fun init() {
        input.init()
        logger.info("CleggJive initialised.")
    }

    override fun onJiveComplete(o: Any) {
        // Do nothing for now.
    }
}