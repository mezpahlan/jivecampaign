package co.uk.jiveelection.campaign.output.twitter;

import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.Output;
import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Configures a Twitter user to tweet on behalf of.
 */
@AutoFactory
public class TwitterOutput implements Output<Status> {

    private static final int TWEET_CHARACTER_LIMIT = 280;
    private static final int TWEET_PAGINATION_INDEX = 265;

    private final Jive jiveBot;
    private final Twitter twitterOutput;

    /**
     * Constructs a new TwitterOutput.
     *
     * @param jiveBot Jive: The Jive bot to attach to
     * @param twitter Twitter: Used to tweet statuses
     */
    public TwitterOutput(Jive jiveBot, @Provided Twitter twitter) {
        this.jiveBot = jiveBot;
        this.twitterOutput = twitter;
    }

    @Override
    public void outputJive(String jive) {
        // Tweet, xzibit style
        // Check if translator is > tweet character limit
        // if yes break into smaller tweet with [1/2], [2,2] suffix
        // if not tweet
        if (jive.length() > TWEET_CHARACTER_LIMIT) {
            int i = jive.lastIndexOf(" ", TWEET_PAGINATION_INDEX);

            if (i != -1) {
                String first = jive.substring(0, i) + " [1/2]";
                String second = jive.substring(i + 1) + " [2/2]";

                onOutputComplete(tweet(first));
                onOutputComplete(tweet(second));
            }
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
            status = twitterOutput.updateStatus(jive);
        } catch (TwitterException e) {
            e.printStackTrace();
            System.out.println(jive);
        }

        return status;
    }
}
