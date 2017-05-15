package co.uk.jiveelection.campaign;

import co.uk.jiveelection.campaign.twit.TwitHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.TwitterException;

import java.io.IOException;

/**
 * Main entry point for the Jive Campaign application. Sets up a continuously running loop that
 * checks the latest tweet from the named candidate, translates it to jive, then tweets it as a
 * jivebot.
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws TwitterException, IOException,
            InterruptedException {

        SpringApplication.run(App.class, args);

        TwitHelper jivebotDavidCameron = new TwitHelper("David_Cameron", TwitConfig.DAVID_JIVERON_ACCESS_TOKEN, TwitConfig.DAVID_JIVERON_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotEdMiliband = new TwitHelper("Ed_Miliband", TwitConfig.ED_JIVEABAND_ACCESS_TOKEN, TwitConfig.ED_JIVEABAND_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotNickClegg = new TwitHelper("nick_clegg", TwitConfig.NICK_JIVEGG_ACCESS_TOKEN, TwitConfig.NICK_JIVEGG_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotTheresaMay = new TwitHelper("theresa_may", TwitConfig.JIVERESA_MAY_ACCESS_TOKEN, TwitConfig.JIVERESA_MAY_ACCESS_TOKEN_SECRET);
    }

}
