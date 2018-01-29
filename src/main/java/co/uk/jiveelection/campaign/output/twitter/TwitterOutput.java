package co.uk.jiveelection.campaign.output.twitter;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.output.Output;
import co.uk.jiveelection.campaign.translator.JiveTranslator;
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

    private static final int TWEET_CHARACTER_LIMIT = 280;
    private static final int TWEET_PAGINATION_INDEX = 265;

    private final String realUserName;
    private final JiveTranslator jiveTranslator;
    private final Twitter twitter;
    private final TwitterStream twitterStream;

    public TwitterOutput(String realUserName, JiveTranslator jiveTranslator, String jivebotToken, String jivebotTokenSecret) {
        this.realUserName = realUserName;
        this.jiveTranslator = jiveTranslator;

        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(jivebotToken)
                .setOAuthAccessTokenSecret(jivebotTokenSecret)
                .build();

        twitter = new TwitterFactory(configuration).getInstance();
        twitterStream = new TwitterStreamFactory(configuration).getInstance();
    }

    private void onStatusReceived(Status status) {
        // Extract status as text
        final List<TranslationEntity> entities = extractEntities(status);

        // Translate the tweet to translator
        final String jive = jiveTranslator.translate(entities);

        // Tweet, xzibit style
        // Check if translator is > tweet character limit
        // if yes break into smaller tweet with [1/2], [2,2] suffix
        // if not tweet
        if (jive.length() > TWEET_CHARACTER_LIMIT) {
            int i = jive.lastIndexOf(" ", TWEET_PAGINATION_INDEX);

            String first = jive.substring(0, i) + " [1/2]";
            String second = jive.substring(i + 1) + " [2/2]";

            outputJive(first);
            outputJive(second);
        } else {
            outputJive(jive);
        }
    }

    public List<TranslationEntity> extractEntities(Status status) {
        // Original status length
        final String text = status.getText();
        final int length = text.length();

        // Begin entity extract
        final List<TranslationEntity> verbatimEntities = new ArrayList<>();
        final List<TranslationEntity> entities = new ArrayList<>();

        // Get URL Entities
        for (int i = 0; i < status.getURLEntities().length; i++) {
            URLEntity urlEntities = status.getURLEntities()[i];
            final int start = urlEntities.getStart();
            final int end = urlEntities.getEnd();
            verbatimEntities.add(TranslationEntity.verbatim(start, end, text.substring(start, end)));
        }

        // Get Media Entities
        for (int i = 0; i < status.getMediaEntities().length; i++) {
            MediaEntity mediaEntities = status.getMediaEntities()[i];
            final int start = mediaEntities.getStart();
            final int end = mediaEntities.getEnd();
            verbatimEntities.add(TranslationEntity.verbatim(start, end, text.substring(start, end)));
        }

        // Get UserMentionEntity if they exists
        for (int i = 0; i < status.getUserMentionEntities().length; i++) {
            UserMentionEntity userMentionEntities = status.getUserMentionEntities()[i];
            final int start = userMentionEntities.getStart();
            final int end = userMentionEntities.getEnd();
            verbatimEntities.add(TranslationEntity.verbatim(start, end, text.substring(start, end)));
        }

        // Get HashtagEntity if they exists
        for (int i = 0; i < status.getHashtagEntities().length; i++) {
            HashtagEntity hashTagEntities = status.getHashtagEntities()[i];
            final int start = hashTagEntities.getStart();
            final int end = hashTagEntities.getEnd();
            verbatimEntities.add(TranslationEntity.verbatim(start, end, text.substring(start, end)));
        }

        // Order verbatim entities by start position
        verbatimEntities.sort(Comparator.comparingInt(TranslationEntity::start));

        // Add translatable entities
        int position = 0;
        for (TranslationEntity verbatimEntity : verbatimEntities) {
            if (verbatimEntity.start() != 0) {
                entities.add(TranslationEntity.translate(position, verbatimEntity.start(), text.substring(position, verbatimEntity.start())));
            }
            entities.add(verbatimEntity);
            position = verbatimEntity.end();
        }

        // Collect the rest of the string to translate
        if (position < length) {
            entities.add(TranslationEntity.translate(position, length, text.substring(position, length)));
        }

        // Order all entities by start position
        entities.sort(Comparator.comparingInt(TranslationEntity::start));

        return entities;
    }

    /**
     * Initialises a filter for the real Twitter user than is to be Jive translated.
     *
     * @throws TwitterException when Twitter service or network is unavailable
     */
    public void init() throws TwitterException {
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
                    if (!status.isRetweet()) {
                        onStatusReceived(status);
                    }
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
            twitter.updateStatus(jive);
        } catch (TwitterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(jive);
        }
    }
}
