package co.uk.jiveelection.campaign.twit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;
import co.uk.jiveelection.campaign.jive.JiveHelper;

public class TwitHelper {
	public static Twitter twitter = new TwitterFactory().getInstance();
	private Status status;
	public String statusText;
	public List<EntitiesModel> entities;

	public TwitHelper(String userName) {
		// Get latest tweet from named user
		try {
			status = twitter.getUserTimeline(userName).get(0);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Extract status as text
		statusText = status.getText();
		
		// Begin entity extract
		entities = new ArrayList<EntitiesModel>();

		// Get URL Entities
		for (int i = 0; i < status.getURLEntities().length; i++) {
			URLEntity urlEntities = status.getURLEntities()[i];
			entities.add(new EntitiesModel(urlEntities.getStart(), urlEntities.getEnd(), urlEntities
					.getText(), urlEntities.getClass().getName()));
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
	}

}
