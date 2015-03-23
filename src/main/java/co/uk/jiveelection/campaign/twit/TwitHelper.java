package co.uk.jiveelection.campaign.twit;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class TwitHelper {
	public static Twitter twitter = new TwitterFactory().getInstance();
	private Status status;	
	public String statusText;
	private List<EntitiesModel> entities;
	
	public TwitHelper(String userName) {
		try {
			status = twitter.getUserTimeline(userName).get(0);
			statusText = status.getText();
//			entities.add();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void addUrlEntities(){
		
	}
}
