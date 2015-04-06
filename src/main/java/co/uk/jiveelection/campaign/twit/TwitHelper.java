package co.uk.jiveelection.campaign.twit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;
import twitter4j.auth.AccessToken;

public class TwitHelper {
	public static Twitter twitter = new TwitterFactory().getInstance();
	private Status status;
	public String statusText;
	public List<EntitiesModel> entities;

	public TwitHelper(String userName) {
		// Get the Access token from the properties file
		AccessToken accessToken = loadAccessToken("davidjiveron");

		// Load access token into configuration
		twitter.setOAuthAccessToken(accessToken);

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
		
		// Send the jive tweet out
	}

	private static AccessToken loadAccessToken(String jiveName){
		// create and load default properties
		Properties properties = new Properties();
		try (FileInputStream in = new FileInputStream("twitter4j.properties")) {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 	String token = properties.getProperty("davidjiveron" + ".accessToken");
	    String tokenSecret = properties.getProperty("davidjiveron" + ".accessTokenSecret");
	    return new AccessToken(token, tokenSecret);
	}
	
	public static void tweetJive(String jive) {
		try {
			Status status = twitter.updateStatus(jive);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
