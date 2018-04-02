package co.uk.jiveelection.campaign.input.twitter;

import co.uk.jiveelection.campaign.input.Input;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity;
import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import twitter4j.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Configures a Twitter user and listens to a tweet timeline.
 * <p>
 * Does not follow retweets.
 */
@AutoFactory
public class TwitterInput implements Input<Status> {

    private final Jive jiveBot;
    private final String realUserName;
    private final Twitter twitter;
    private final TwitterStream twitterStream;

    /**
     * Constructs a new TwitterInput.
     *
     * @param jiveBot       Jive: The Jive bot to attach to
     * @param realUserName  String: The real username to follow
     * @param twitter       Twitter: Used to retrieve the real user id
     * @param twitterStream TwitterStream: Used to listen to tweets from the real user
     */
    public TwitterInput(Jive jiveBot, @Provided String realUserName, @Provided Twitter twitter, @Provided TwitterStream twitterStream) {
        this.jiveBot = jiveBot;
        this.realUserName = realUserName;
        this.twitter = twitter;
        this.twitterStream = twitterStream;
    }

    public void init() throws TwitterException {
        long realId = twitter.showUser(realUserName).getId();

        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.follow(realId);

        twitterStream
                .onStatus(status -> {
                    if (status.getUser().getId() == realId) {
                        if (!status.isRetweet()) {
                            final List<TranslationEntity> translationEntities = extractEntities(status);
                            jiveBot.onInputReceived(translationEntities);
                        }
                    }
                })
                .filter(tweetFilterQuery);
    }

    @Override
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
}
