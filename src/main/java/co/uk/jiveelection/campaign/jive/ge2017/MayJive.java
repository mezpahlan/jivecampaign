package co.uk.jiveelection.campaign.jive.ge2017;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.input.twitter.TwitterInput;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class MayJive extends Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator> {

    public MayJive() {
        final Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.JIVERESA_MAY_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.JIVERESA_MAY_ACCESS_TOKEN_SECRET)
                .build();

        final Twitter jiveMayTwitter = new TwitterFactory(configuration).getInstance();
        final TwitterStream jiveMayTwitterStream = new TwitterStreamFactory(configuration).getInstance();

        input = new TwitterInput(this, "theresa_may", jiveMayTwitter, jiveMayTwitterStream);
        output = new TwitterOutput(this, jiveMayTwitter);
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
