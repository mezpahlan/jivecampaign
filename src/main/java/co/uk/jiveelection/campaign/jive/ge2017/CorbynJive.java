package co.uk.jiveelection.campaign.jive.ge2017;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.input.twitter.TwitterInput;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class CorbynJive extends Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator> {

    public CorbynJive() {
        final Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.JEREMY_JIVEBYN_ACCESS_TOKEN_SECRET)
                .build();

        final Twitter jiveCorbynTwitter = new TwitterFactory(configuration).getInstance();
        final TwitterStream jiveCorbynTwitterStream = new TwitterStreamFactory(configuration).getInstance();

        input = new TwitterInput(this, "jeremycorbyn", jiveCorbynTwitter, jiveCorbynTwitterStream);
        output = new TwitterOutput(this, jiveCorbynTwitter);
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
