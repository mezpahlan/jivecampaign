package co.uk.jiveelection.campaign.twit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import co.uk.jiveelection.campaign.jive.JiveHelper;

public class TwitHelper {
	public String statusText;
	private static Twitter twitter;
	private Properties properties;
	private Properties consumer;
	private Status status;
	private long tweetId;
	private List<EntitiesModel> entities;
	private String jiveUserName;
	private String realUserName;
	private String propertyFile;

	public TwitHelper(String realUserName, String jiveUserName) {
		this.jiveUserName = jiveUserName;
		this.realUserName = realUserName;
		this.propertyFile = System.getenv().get("OPENSHIFT_DATA_DIR") + jiveUserName + ".properties";
		// Initialise the TwitHelper
		init();

		// Get latest tweet from named user
		try {
			status = twitter.getUserTimeline(realUserName).get(0);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Extract the current Tweet Id
		this.tweetId = status.getId();

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

			// Translate the tweet to jive
			String jive = JiveHelper.translateToJive(statusText, entities);

			// Tweet, xzibit style
			// Check if jive is > 140 characters
			// if yes break into smaller tweet with [1/2], [2,2] suffix
			// if not tweet
			if (jive.length() > 140) {
				int i = jive.lastIndexOf(" ", 132);
				
				String first = jive.substring(0, i) + " [1/2]";
				String second  = jive.substring(i + 1) + " [2/2]";
				
				tweetJive(first);
				tweetJive(second);
			} else {
				tweetJive(jive);
			}

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
		// Attempt to load a static twitter that we use for all Twitter related tasks
		loadConsumerConfig();
		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumer.getProperty("oauth.consumerKey"),
				consumer.getProperty("oauth.consumerSecret"));

		// Load properties
		loadProperties();

		// Get the Access token from the properties file
		AccessToken accessToken = loadAccessToken();

		// Load access token into configuration
		twitter.setOAuthAccessToken(accessToken);

	}

	private void loadConsumerConfig() {
		// Creates consumer properties
		this.consumer = new Properties();

		try (FileInputStream in = new FileInputStream(System.getenv().get("OPENSHIFT_DATA_DIR")
				+ "twitter4j.properties")) {
			this.consumer.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Loads the properties object associated with Jive Bot from a file
	 */
	private void loadProperties() {
		// Create and load default properties
		this.properties = new Properties();

		// TODO: Make the stream a final constant
		try (FileInputStream in = new FileInputStream(propertyFile)) {
			this.properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Checks if the current tweet was sent after the last tweet that we processed.
	 * 
	 * @return True is newer, false if older
	 */
	private boolean isNewTweet() {
		// TODO: Make the property a final constant?
		String s = properties.getProperty("lastTweetId", "0");
		if (!(s.length() > 0)) {
			// Assume this is a blank string since we're confident this isn't null here
			s = "0";
		}
		
		long lastTweet = Long.valueOf(s).longValue();
	
		boolean result = ( status.getId() > lastTweet ) ? true : false;
	
		if (result) {
			System.out.println("New tweet for " + realUserName + ". This tweet: " + String.valueOf(status.getId()) + " . Old tweet: " + String.valueOf(lastTweet));
		} else {
			System.out.println("Seen this tweet before from " + realUserName + ". This tweet: " + String.valueOf(status.getId()) + " . Old tweet: " + String.valueOf(lastTweet));
		}
	
		return result;
	}

	/**
	 * Updates the last Tweet Id in the properties object
	 */
	private void updateLastTweetProperty() {
		if (null != properties) {
			// TODO: Make the property a final constant
			properties.setProperty("lastTweetId", String.valueOf(tweetId));
		} else {
			// Log this properly
			System.out.println("Properties not loaded");
		}
	}

	/**
	 * Saves the properties object associated with the Jive Bot to a file
	 */
	private void saveProperties() {
		if (null != properties) {
			// TODO: Make the stream a final constant
			try (FileOutputStream out = new FileOutputStream(propertyFile)) {
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
			System.out.println(status);
			System.out.println(jive);
		}
	}
}
