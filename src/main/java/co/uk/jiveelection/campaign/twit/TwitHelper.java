package co.uk.jiveelection.campaign.twit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import co.uk.jiveelection.campaign.jive.JiveHelper;

public class TwitHelper {
	public String statusText;
	private static Twitter twitter = new TwitterFactory().getInstance();
	private Properties properties;
	private Status status;
	private Date lastTweeted;
	private List<EntitiesModel> entities;
	private String jiveUserName;

	public TwitHelper(String realUserName, String jiveUserName) {
		this.jiveUserName = jiveUserName;

		// Initialise the TwitHelper
		init();

		// Get latest tweet from named user
		try {
			status = twitter.getUserTimeline(realUserName).get(0);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Extract the last tweeted date time
		this.lastTweeted = status.getCreatedAt();

		if (isNewTweet()) {
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

			// Translate the tweet to jive and tweet, xzibit style
			tweetJive(JiveHelper.translateToJive(statusText, entities));
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
	private void init() {
		// Load properties
		loadProperties();

		// Get the Access token from the properties file
		AccessToken accessToken = loadAccessToken();

		// Load access token into configuration
		twitter.setOAuthAccessToken(accessToken);

	}

	/**
	 * Loads the properties object associated with Jive Bot from a file
	 */
	private void loadProperties() {
		// Create and load default properties
		this.properties = new Properties();

		// TODO: Make the stream a final constant
		try (FileInputStream in = new FileInputStream(jiveUserName + ".properties")) {
			this.properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Saves the properties object associated with the Jive Bot to a file
	 */
	private void saveProperties() {
		if (null != properties) {
			// TODO: Make the stream a final constant
			try (FileOutputStream out = new FileOutputStream(jiveUserName + ".properties")) {
				properties.store(out, jiveUserName + " properties");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Properties not loaded");
		}

	}

	/**
	 * Uses properties from the properties object to create a new Access Token allowing us to Tweet
	 * on the jivebot's behalf.
	 * 
	 * @return A new Access Token
	 */
	private AccessToken loadAccessToken() {
		// TODO: Investigate StringBuilder
		String token = properties.getProperty("accessToken");
		String tokenSecret = properties.getProperty("accessTokenSecret");
		return new AccessToken(token, tokenSecret);
	}

	/**
	 * Checks if the current tweet was sent after the last tweet that we processed.
	 * 
	 * @return True is newer, false if older
	 * @throws ParseException
	 */
	private boolean isNewTweet() {
		// TODO: Make the property a final constant
		String lastTweet = properties.getProperty("lastTweeted", "Tue Apr 07 00:00:00 BST 2015");
		if (!(lastTweet.length() > 0)) {
			// Assume this is a blank string since we're confident this isn't null here
			lastTweet = "Tue Apr 07 00:00:00 BST 2015";
		}

		DateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
		Date date = null;
		try {
			date = format.parse(lastTweet);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status.getCreatedAt().after(date);
	}

	/**
	 * Tweets the jive text via the authenticated jive bot
	 * 
	 * @param jive The String to be tweeted
	 */
	public void tweetJive(String jive) {
		try {
			Status status = twitter.updateStatus(jive);
			updateLastTweetProperty();
			saveProperties();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Updates the last tweeted date in the properties object
	 */
	private void updateLastTweetProperty() {
		if (null != properties) {
			// TODO: Make the property a final constant
			properties.put("lastTweeted", lastTweeted.toString());
		} else {
			// Log this properly
			System.out.println("Properties not loaded");
		}
	}
}
