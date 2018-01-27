package co.uk.jiveelection.campaign;

import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
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
        TwitterOutput jivebotDavidCameron = new TwitterOutput("David_Cameron", new InMemoryJiveTranslator(), TwitConfig.DAVID_JIVERON_ACCESS_TOKEN, TwitConfig.DAVID_JIVERON_ACCESS_TOKEN_SECRET);
        jivebotDavidCameron.init();

        TwitterOutput jivebotEdMiliband = new TwitterOutput("Ed_Miliband", new InMemoryJiveTranslator(), TwitConfig.ED_JIVEABAND_ACCESS_TOKEN, TwitConfig.ED_JIVEABAND_ACCESS_TOKEN_SECRET);
        jivebotEdMiliband.init();

        TwitterOutput jivebotNickClegg = new TwitterOutput("nick_clegg", new InMemoryJiveTranslator(), TwitConfig.NICK_JIVEGG_ACCESS_TOKEN, TwitConfig.NICK_JIVEGG_ACCESS_TOKEN_SECRET);
        jivebotNickClegg.init();

        // GE2017
        TwitterOutput jivebotTheresaMay = new TwitterOutput("theresa_may", new InMemoryJiveTranslator(), TwitConfig.JIVERESA_MAY_ACCESS_TOKEN, TwitConfig.JIVERESA_MAY_ACCESS_TOKEN_SECRET);
        jivebotTheresaMay.init();

        TwitterOutput jivebotJeremyCorbyn = new TwitterOutput("jeremycorbyn", new InMemoryJiveTranslator(), TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN, TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN_SECRET);
        jivebotJeremyCorbyn.init();

        TwitterOutput jivebotJiveFarron = new TwitterOutput("timfarron", new InMemoryJiveTranslator(), TwitConfig.JIVE_FARRON_ACCESS_TOKEN, TwitConfig.JIVE_FARRON_ACCESS_TOKEN_SECRET);
        jivebotJiveFarron.init();

        TwitterOutput jivebotJiveolaSturgeon = new TwitterOutput("NicolaSturgeon", new InMemoryJiveTranslator(), TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN, TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN_SECRET);
        jivebotJiveolaSturgeon.init();

        TwitterOutput jivebotJiveanneWood = new TwitterOutput("LeanneWood", new InMemoryJiveTranslator(), TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN, TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN_SECRET);
        jivebotJiveanneWood.init();

        TwitterOutput jivebotJiveolineLucas = new TwitterOutput("CarolineLucas", new InMemoryJiveTranslator(), TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN, TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN_SECRET);
        jivebotJiveolineLucas.init();
    }

}
