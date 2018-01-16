package co.uk.jiveelection.campaign;

import co.uk.jiveelection.campaign.jive.InMemoryJiveTranslator;
import co.uk.jiveelection.campaign.twit.TweetHelper;
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
        TweetHelper jivebotDavidCameron = new TweetHelper("David_Cameron", TwitConfig.DAVID_JIVERON_ACCESS_TOKEN, TwitConfig.DAVID_JIVERON_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TweetHelper jivebotEdMiliband = new TweetHelper("Ed_Miliband", TwitConfig.ED_JIVEABAND_ACCESS_TOKEN, TwitConfig.ED_JIVEABAND_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TweetHelper jivebotNickClegg = new TweetHelper("nick_clegg", TwitConfig.NICK_JIVEGG_ACCESS_TOKEN, TwitConfig.NICK_JIVEGG_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());

        // GE2017
        TweetHelper jivebotTheresaMay = new TweetHelper("theresa_may", TwitConfig.JIVERESA_MAY_ACCESS_TOKEN, TwitConfig.JIVERESA_MAY_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TweetHelper jivebotJeremyCorbyn = new TweetHelper("jeremycorbyn", TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN, TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TweetHelper jivebotJiveFarron = new TweetHelper("timfarron", TwitConfig.JIVE_FARRON_ACCESS_TOKEN, TwitConfig.JIVE_FARRON_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TweetHelper jivebotJiveolaSturgeon = new TweetHelper("NicolaSturgeon", TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN, TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TweetHelper jivebotJiveanneWood = new TweetHelper("LeanneWood", TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN, TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TweetHelper jivebotJiveolineLucas = new TweetHelper("CarolineLucas", TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN, TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
    }

}
