package co.uk.jiveelection.campaign.jive.ge2017

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

class MayJive @Inject
constructor(
        twitterInputFactory: TwitterInputFactory,
        twitterOutputFactory: TwitterOutputFactory,
        inMemoryJiveTranslatorFactory: InMemoryJiveTranslatorFactory
) : Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator>() {

    private val logger: Logger = LoggerFactory.getLogger(MayJive::class.java)

    override val input: TwitterInput = twitterInputFactory.create(this)
    override val output: TwitterOutput = twitterOutputFactory.create(this)
    override val translator: InMemoryJiveTranslator = inMemoryJiveTranslatorFactory.create(this)

    @Throws(TwitterException::class)
    override fun init() {
        input.init()
        logger.info("MayJive initialised.")
    }

    override fun onJiveComplete(o: Any) {
        // Do nothing for now.
    }
}
