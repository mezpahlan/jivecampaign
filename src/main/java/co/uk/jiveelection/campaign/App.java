package co.uk.jiveelection.campaign;

import java.io.IOException;

import twitter4j.TwitterException;
import co.uk.jiveelection.campaign.jive.JiveHelper;
import co.uk.jiveelection.campaign.twit.TwitHelper;

/**
 * Hello world!
 *
 */
public class App {

	
	public static void main(String[] args) throws TwitterException, IOException {
//		TwitHelper mezPahlan = new TwitHelper("mezpahlan");
		TwitHelper jivebotDavidCameron = new TwitHelper("David_Cameron", "davidjiveron");
//		TwitHelper edMiliband = new TwitHelper("Ed_Miliband");
//		TwitHelper nickClegg = new TwitHelper("nick_clegg");
//
//		System.out.println(JiveHelper.translateToJive(mezPahlan));
		String davidJiveronStatusUpdate = JiveHelper.translateToJive(jivebotDavidCameron);
		jivebotDavidCameron.tweetJive(davidJiveronStatusUpdate);
//		System.out.println(JiveHelper.translateToJive(edMiliband));
//		System.out.println(JiveHelper.translateToJive(nickClegg));

	  }
		
}
