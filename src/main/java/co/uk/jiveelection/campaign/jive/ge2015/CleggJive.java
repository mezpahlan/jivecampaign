package co.uk.jiveelection.campaign.jive.ge2015;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.input.twitter.TwitterInput;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class CleggJive extends Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator> {

    public CleggJive() {
        final Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.NICK_JIVEGG_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.NICK_JIVEGG_ACCESS_TOKEN_SECRET)
                .build();

        final Twitter jiveCleggTwitter = new TwitterFactory(configuration).getInstance();
        final TwitterStream jiveCleggTwitterStream = new TwitterStreamFactory(configuration).getInstance();

        input = new TwitterInput(this, "nick_clegg", jiveCleggTwitter, jiveCleggTwitterStream);
        output = new TwitterOutput(this, jiveCleggTwitter);
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