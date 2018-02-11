package co.uk.jiveelection.campaign.jive.ge2017;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.input.twitter.TwitterInput;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class WoodJive extends Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator> {

    public WoodJive() {
        final Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN_SECRET)
                .build();

        final Twitter jiveWoodTwitter = new TwitterFactory(configuration).getInstance();
        final TwitterStream jiveWoodTwitterStream = new TwitterStreamFactory(configuration).getInstance();

        input = new TwitterInput(this, "LeanneWood", jiveWoodTwitter, jiveWoodTwitterStream);
        output = new TwitterOutput(this, jiveWoodTwitter);
        translator = new InMemoryJiveTranslator(this);
    }

    @Override
    public void init() throws TwitterException {
        input.init();
    }

    @Override
    public void onJiveComplete(Object o) {
        // Do nothing for now.
    }
}
