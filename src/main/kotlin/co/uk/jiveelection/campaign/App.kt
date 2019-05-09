package co.uk.jiveelection.campaign

import co.uk.jiveelection.campaign.injection.DaggerJiveCampaign
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import twitter4j.TwitterException

/**
 * Main entry point for the Jive Campaign application. Sets up a continuously running loop that
 * checks the latest tweet from the named candidate, translates it to translator, then tweets it as a
 * jivebot.
 */
@SpringBootApplication
object App {

    @Throws(TwitterException::class)
    @JvmStatic
    fun main(args: Array<String>) {

        SpringApplication.run(App::class.java, *args)
        val jiveCampaign = DaggerJiveCampaign.builder().build()

        // GE2015
        val cameronJive = jiveCampaign.cameron()
        cameronJive.init()

        val milibandJive = jiveCampaign.miliband()
        milibandJive.init()

        val cleggJive = jiveCampaign.clegg()
        cleggJive.init()

        // GE2017
        val mayJive = jiveCampaign.may()
        mayJive.init()

        val corbynJive = jiveCampaign.corbyn()
        corbynJive.init()

        val farronJive = jiveCampaign.farron()
        farronJive.init()

        val sturgeonJive = jiveCampaign.sturgeon()
        sturgeonJive.init()

        val woodJive = jiveCampaign.wood()
        woodJive.init()

        val lucasJive = jiveCampaign.lucas()
        lucasJive.init()
    }
}
