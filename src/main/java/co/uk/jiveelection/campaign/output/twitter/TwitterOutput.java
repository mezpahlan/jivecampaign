package co.uk.jiveelection.campaign.output.twitter;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.jive.JiveTranslator;
import co.uk.jiveelection.campaign.output.Output;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Configures a Twitter user to tweet on behalf of.
 */
public class TwitterOutput implements Output {
    private final JiveTranslator jiveTranslator;
    private Twitter twitter;

    // TODO: Builder
    public TwitterOutput(String realUserName, String jivebotToken, String jivebotTokenSecret, JiveTranslator jiveTranslator) throws TwitterException {
        this.jiveTranslator = jiveTranslator;
        // Initialise the TwitterOutput
        init(realUserName, jivebotToken, jivebotTokenSecret);
    }

    private void onStatusReceived(Status status) {
        // Extract status as text
        String statusText = status.getText();
        final List<EntitiesModel> entities = extractEntities(status);

        // Translate the tweet to jive
        String jive = translateStatus(statusText, entities);

        // Tweet, xzibit style
        // Check if jive is > 280 characters
        // if yes break into smaller tweet with [1/2], [2,2] suffix
        // if not tweet
        if (jive.length() > 280) {
            int i = jive.lastIndexOf(" ", 265);

            String first = jive.substring(0, i) + " [1/2]";
            String second = jive.substring(i + 1) + " [2/2]";

            outputJive(first);
            outputJive(second);
        } else {
            outputJive(jive);
        }
    }

    private List<EntitiesModel> extractEntities(Status status) {
        // Begin entity extract
        final List<EntitiesModel> entities = new ArrayList<>();

        // Get URL Entities
        for (int i = 0; i < status.getURLEntities().length; i++) {
            URLEntity urlEntities = status.getURLEntities()[i];
            entities.add(EntitiesModel.create(urlEntities.getStart(), urlEntities.getEnd()));
        }

        // Get Media Entities
        for (int i = 0; i < status.getMediaEntities().length; i++) {
            MediaEntity mediaEntities = status.getMediaEntities()[i];
            entities.add(EntitiesModel.create(mediaEntities.getStart(), mediaEntities.getEnd()));
        }

        // Get UserMentionEntity if they exists
        for (int i = 0; i < status.getUserMentionEntities().length; i++) {
            UserMentionEntity userMentionEntities = status.getUserMentionEntities()[i];
            entities.add(EntitiesModel.create(userMentionEntities.getStart(), userMentionEntities
                    .getEnd()));
        }

        // Get HashtagEntity if they exists
        for (int i = 0; i < status.getHashtagEntities().length; i++) {
            HashtagEntity hashTagEntities = status.getHashtagEntities()[i];
            entities.add(EntitiesModel.create(hashTagEntities.getStart(), hashTagEntities.getEnd()));
        }

        // Order the List of Entities by start position
        entities.sort(Comparator.comparingInt(EntitiesModel::start));

        return entities;
    }

    private String translateStatus(String statusText, List<EntitiesModel> entities) {
        int position = 0;
        StringBuilder builder = new StringBuilder();
        for (EntitiesModel entity : entities) {
            builder.append(jiveTranslator.translate(statusText.substring(position, entity.start())))
                    .append(" ")
                    .append(jiveTranslator.translate(statusText.substring(entity.start(), entity.end())))
                    .append(" ");
            position = entity.end() + 1;
        }

        // Here we have no more entities but could still have text to jivelate
        if (position < statusText.length()) {
            builder.append(jiveTranslator.translate(statusText.substring(position)));
        }

        // TODO: encode the spaces in the entities?
        return builder.toString();
    }

    /**
     * Initialises the TwitterOutput. Loads the authentication for the Jive Bot.
     *
     * @param jivebotToken
     * @param jivebotTokenSecret
     */
    private void init(String realUserName, String jivebotToken, String jivebotTokenSecret) throws TwitterException {
        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(jivebotToken)
                .setOAuthAccessTokenSecret(jivebotTokenSecret)
                .build();

        twitter = new TwitterFactory(configuration).getInstance();
        TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();
        long realId = twitter.showUser(realUserName).getId();

        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.follow(realId);

        twitterStream.addListener(new StatusListener() {
            @Override
            public void onException(Exception ex) {

            }

            @Override
            public void onStatus(Status status) {
                if (status.getUser().getId() == realId) {
                    onStatusReceived(status);
                }
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

    @Override
    public void outputJive(String jive) {
        try {
            Status status = twitter.updateStatus(jive);
        } catch (TwitterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(jive);
        }
    }
}
