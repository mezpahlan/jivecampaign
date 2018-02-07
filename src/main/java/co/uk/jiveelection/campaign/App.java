package co.uk.jiveelection.campaign;

import co.uk.jiveelection.campaign.jive.ge2015.CameronJive;
import co.uk.jiveelection.campaign.jive.ge2015.CleggJive;
import co.uk.jiveelection.campaign.jive.ge2015.MilibandJive;
import co.uk.jiveelection.campaign.jive.ge2017.*;
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
        final CameronJive cameronJive = new CameronJive();
        cameronJive.init();

        final MilibandJive milibandJive = new MilibandJive();
        milibandJive.init();

        final CleggJive cleggJive = new CleggJive();
        cleggJive.init();

        // GE2017
        final MayJive mayJive = new MayJive();
        mayJive.init();

        final CorbynJive corbynJive = new CorbynJive();
        corbynJive.init();

        final FarronJive farronJive = new FarronJive();
        farronJive.init();

        final SturgeonJive sturgeonJive = new SturgeonJive();
        sturgeonJive.init();

        final WoodJive woodJive = new WoodJive();
        woodJive.init();

        final LucasJive lucasJive = new LucasJive();
        lucasJive.init();
    }

}
