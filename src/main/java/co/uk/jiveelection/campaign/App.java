package co.uk.jiveelection.campaign;

import co.uk.jiveelection.campaign.twit.TwitHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.TwitterException;

/**
 * Main entry point for the Jive Campaign application. Sets up a continuously running loop that
 * checks the latest tweet from the named candidate, translates it to jive, then tweets it as a
 * jivebot.
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws TwitterException {

        SpringApplication.run(App.class, args);

        // GE2015
        TwitHelper jivebotDavidCameron = new TwitHelper("David_Cameron", TwitConfig.DAVID_JIVERON_ACCESS_TOKEN, TwitConfig.DAVID_JIVERON_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotEdMiliband = new TwitHelper("Ed_Miliband", TwitConfig.ED_JIVEABAND_ACCESS_TOKEN, TwitConfig.ED_JIVEABAND_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotNickClegg = new TwitHelper("nick_clegg", TwitConfig.NICK_JIVEGG_ACCESS_TOKEN, TwitConfig.NICK_JIVEGG_ACCESS_TOKEN_SECRET);

        // GE2017
        TwitHelper jivebotTheresaMay = new TwitHelper("theresa_may", TwitConfig.JIVERESA_MAY_ACCESS_TOKEN, TwitConfig.JIVERESA_MAY_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotJeremyCorbyn = new TwitHelper("jeremycorbyn", TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN, TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotJiveFarron = new TwitHelper("timfarron", TwitConfig.JIVE_FARRON_ACCESS_TOKEN, TwitConfig.JIVE_FARRON_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotJiveolaSturgeon = new TwitHelper("NicolaSturgeon", TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN, TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotJiveanneWood = new TwitHelper("LeanneWood", TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN, TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN_SECRET);
        TwitHelper jivebotJiveolineLucas = new TwitHelper("CarolineLucas", TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN, TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN_SECRET);
    }

}
