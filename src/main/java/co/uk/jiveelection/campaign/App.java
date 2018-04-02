package co.uk.jiveelection.campaign;

import co.uk.jiveelection.campaign.injection.DaggerJiveCampaign;
import co.uk.jiveelection.campaign.injection.JiveCampaign;
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
        final JiveCampaign jiveCampaign = DaggerJiveCampaign.create();

        // GE2015
        final CameronJive cameronJive = jiveCampaign.cameron();
        cameronJive.init();

        final MilibandJive milibandJive = jiveCampaign.miliband();
        milibandJive.init();

        final CleggJive cleggJive = jiveCampaign.clegg();
        cleggJive.init();

        // GE2017
        final MayJive mayJive = jiveCampaign.may();
        mayJive.init();

        final CorbynJive corbynJive = jiveCampaign.corbyn();
        corbynJive.init();

        final FarronJive farronJive = jiveCampaign.farron();
        farronJive.init();

        final SturgeonJive sturgeonJive = jiveCampaign.sturgeon();
        sturgeonJive.init();

        final WoodJive woodJive = jiveCampaign.wood();
        woodJive.init();

        final LucasJive lucasJive = jiveCampaign.lucas();
        lucasJive.init();
    }

}
