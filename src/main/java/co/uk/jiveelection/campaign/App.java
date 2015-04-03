package co.uk.jiveelection.campaign;

import twitter4j.Status;
import co.uk.jiveelection.campaign.jive.JiveHelper;
import co.uk.jiveelection.campaign.twit.TwitHelper;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		TwitHelper mezPahlan = new TwitHelper("mezpahlan");
		TwitHelper davidCameron = new TwitHelper("David_Cameron");
		TwitHelper edMiliband = new TwitHelper("Ed_Miliband");
		TwitHelper nickClegg = new TwitHelper("nick_clegg");

		System.out.println(JiveHelper.translateToJive(mezPahlan));
		System.out.println(JiveHelper.translateToJive(davidCameron));
		System.out.println(JiveHelper.translateToJive(edMiliband));
		System.out.println(JiveHelper.translateToJive(nickClegg));

	}
}
