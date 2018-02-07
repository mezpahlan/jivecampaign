package co.uk.jiveelection.campaign.output.twitter;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.Output;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Configures a Twitter user to tweet on behalf of.
 */
public class TwitterOutput implements Output<Status> {

    private static final int TWEET_CHARACTER_LIMIT = 280;
    private static final int TWEET_PAGINATION_INDEX = 265;

    private final Jive jiveBot;
    private final Twitter twitter;

    public TwitterOutput(Jive jiveBot, String jivebotToken, String jivebotTokenSecret) {
        this.jiveBot = jiveBot;

        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(jivebotToken)
                .setOAuthAccessTokenSecret(jivebotTokenSecret)
                .build();

        twitter = new TwitterFactory(configuration).getInstance();
    }

    @Override
    public void outputJive(String jive) {
        // Tweet, xzibit style
        // Check if translator is > tweet character limit
        // if yes break into smaller tweet with [1/2], [2,2] suffix
        // if not tweet
        if (jive.length() > TWEET_CHARACTER_LIMIT) {
            int i = jive.lastIndexOf(" ", TWEET_PAGINATION_INDEX);

            String first = jive.substring(0, i) + " [1/2]";
            String second = jive.substring(i + 1) + " [2/2]";

            onOutputComplete(tweet(first));
            onOutputComplete(tweet(second));
        } else {
            onOutputComplete(tweet(jive));
        }
    }

    @Override
    public void onOutputComplete(Status status) {
        jiveBot.onJiveComplete(status);
    }

    private Status tweet(String jive) {
        Status status = null;

        try {
            status = twitter.updateStatus(jive);
        } catch (TwitterException e) {
            e.printStackTrace();
            System.out.println(jive);
        }

        return status;
    }
}
