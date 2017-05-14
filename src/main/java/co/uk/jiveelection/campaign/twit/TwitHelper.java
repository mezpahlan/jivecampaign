package co.uk.jiveelection.campaign.twit;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.jive.JiveHelper;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwitHelper {
    public String statusText;
    private Twitter twitter;
    private Status status;
    private long tweetId;
    private List<EntitiesModel> entities;
    private String jiveUserName;
    private String realUserName;
    private String jivebotToken;
    private String jivebotTokenSecret;
    private TwitterStream twitterStream;

    public TwitHelper(String realUserName, String jiveUserName, String jivebotToken, String jivebotTokenSecret) throws TwitterException {
        this.jiveUserName = jiveUserName;
        this.realUserName = realUserName;
        this.jivebotToken = jivebotToken;
        this.jivebotTokenSecret = jivebotTokenSecret;

        // Initialise the TwitHelper
        init();
    }

    private void translateToJive(Status status) {
        // Extract status as text
        this.statusText = status.getText();

        // Begin entity extract
        this.entities = new ArrayList<EntitiesModel>();

        // Get URL Entities
        for (int i = 0; i < status.getURLEntities().length; i++) {
            URLEntity urlEntities = status.getURLEntities()[i];
            entities.add(new EntitiesModel(urlEntities.getStart(), urlEntities.getEnd(),
                    urlEntities.getText(), urlEntities.getClass().getName()));
        }

        // Get Media Entities
        for (int i = 0; i < status.getMediaEntities().length; i++) {
            MediaEntity mediaEntities = status.getMediaEntities()[i];
            entities.add(new EntitiesModel(mediaEntities.getStart(), mediaEntities.getEnd(),
                    mediaEntities.getText(), mediaEntities.getClass().getName()));
        }

        // Get UserMentionEntity if they exists
        for (int i = 0; i < status.getUserMentionEntities().length; i++) {
            UserMentionEntity userMentionEntities = status.getUserMentionEntities()[i];
            entities.add(new EntitiesModel(userMentionEntities.getStart(), userMentionEntities
                    .getEnd(), userMentionEntities.getText(), userMentionEntities.getClass()
                    .getName()));
        }

        // Get HashtagEntity if they exists
        for (int i = 0; i < status.getHashtagEntities().length; i++) {
            HashtagEntity hashTagEntities = status.getHashtagEntities()[i];
            entities.add(new EntitiesModel(hashTagEntities.getStart(), hashTagEntities.getEnd(),
                    hashTagEntities.getText(), hashTagEntities.getClass().getName()));
        }

        // Order the List of Entities by start position
        Collections.sort(entities);

        // Translate the tweet to jive
        String jive = JiveHelper.translateToJive(statusText, entities);

        // Tweet, xzibit style
        // Check if jive is > 140 characters
        // if yes break into smaller tweet with [1/2], [2,2] suffix
        // if not tweet
        if (jive.length() > 140) {
            int i = jive.lastIndexOf(" ", 132);

            String first = jive.substring(0, i) + " [1/2]";
            String second = jive.substring(i + 1) + " [2/2]";

            tweetJive(first);
            tweetJive(second);
        } else {
            tweetJive(jive);
        }
    }

    /**
     * @return The entities
     */
    public List<EntitiesModel> getEntities() {
        return entities;
    }

    /**
     * Initialises the TwitHelper. Loads the authentication for the Jive Bot.
     */
    private void init() throws TwitterException {
        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(jivebotToken)
                .setOAuthAccessTokenSecret(jivebotTokenSecret)
                .build();

        twitter = new TwitterFactory(configuration).getInstance();
        twitterStream = new TwitterStreamFactory(configuration).getInstance();

        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.follow(twitter.showUser(realUserName).getId());

        twitterStream.addListener(new StatusListener() {
            @Override
            public void onException(Exception ex) {

            }

            @Override
            public void onStatus(Status status) {
                translateToJive(status);
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {

            }

            @Override
            public void onStallWarning(StallWarning warning) {

            }
        });
        twitterStream.filter(tweetFilterQuery);
    }

    /**
     * Tweets the jive text via the authenticated jive bot
     *
     * @param jive The String to be tweeted
     */
    public void tweetJive(String jive) {
        try {
            Status status = twitter.updateStatus(jive);
        } catch (TwitterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(status);
            System.out.println(jive);
        }
    }
}
