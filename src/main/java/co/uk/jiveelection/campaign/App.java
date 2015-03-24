package co.uk.jiveelection.campaign;

import twitter4j.Status;
import co.uk.jiveelection.campaign.jive.JiveHelper;
import co.uk.jiveelection.campaign.twit.TwitHelper;

/**
 * Hello world!
 *
 */
public class App {
	
	private static void translateToJive(Status input) {
		String jiveText = "";
//		for input.getHashtagEntities().length
	}
	
	public static void main(String[] args) {
		TwitHelper twitter = new TwitHelper("twitter");
		TwitHelper davidCameron = new TwitHelper("David_Cameron");
		TwitHelper edMiliband = new TwitHelper("Ed_Miliband");
		TwitHelper nickClegg = new TwitHelper("nick_clegg");
//		Status dcStatus = davidCameron.getLatestStatus();
//		translateToJive(dcStatus);
		
//		System.out.println(dcStatus.getText());
//		System.out.println(JiveHelper.translateToJive(dcTweetText));
//		System.out.println(emStatus.getText());
//		System.out.println(JiveHelper.translateToJive(emTweetText));
//		System.out.println(ncStatus.getText());
//		System.out.println(JiveHelper.translateToJive(ncTweetText));
		
	}
}
