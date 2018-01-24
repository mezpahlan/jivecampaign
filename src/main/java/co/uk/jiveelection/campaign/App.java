package co.uk.jiveelection.campaign;

import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.TwitterException;

/**
 * Main entry point for the Jive Campaign application. Sets up a continuously running loop that
 * checks the latest tweet from the named candidate, translates it to translator, then tweets it as a
 * jivebot.
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws TwitterException {

        SpringApplication.run(App.class, args);

        // GE2015
        TwitterOutput jivebotDavidCameron = new TwitterOutput("David_Cameron", TwitConfig.DAVID_JIVERON_ACCESS_TOKEN, TwitConfig.DAVID_JIVERON_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TwitterOutput jivebotEdMiliband = new TwitterOutput("Ed_Miliband", TwitConfig.ED_JIVEABAND_ACCESS_TOKEN, TwitConfig.ED_JIVEABAND_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TwitterOutput jivebotNickClegg = new TwitterOutput("nick_clegg", TwitConfig.NICK_JIVEGG_ACCESS_TOKEN, TwitConfig.NICK_JIVEGG_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());

        // GE2017
        TwitterOutput jivebotTheresaMay = new TwitterOutput("theresa_may", TwitConfig.JIVERESA_MAY_ACCESS_TOKEN, TwitConfig.JIVERESA_MAY_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TwitterOutput jivebotJeremyCorbyn = new TwitterOutput("jeremycorbyn", TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN, TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TwitterOutput jivebotJiveFarron = new TwitterOutput("timfarron", TwitConfig.JIVE_FARRON_ACCESS_TOKEN, TwitConfig.JIVE_FARRON_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TwitterOutput jivebotJiveolaSturgeon = new TwitterOutput("NicolaSturgeon", TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN, TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TwitterOutput jivebotJiveanneWood = new TwitterOutput("LeanneWood", TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN, TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
        TwitterOutput jivebotJiveolineLucas = new TwitterOutput("CarolineLucas", TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN, TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN_SECRET, new InMemoryJiveTranslator());
    }

}
