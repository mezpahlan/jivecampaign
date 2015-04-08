package co.uk.jiveelection.campaign;

import java.io.IOException;

import twitter4j.TwitterException;
import co.uk.jiveelection.campaign.jive.JiveHelper;
import co.uk.jiveelection.campaign.twit.TwitHelper;

/**
 * Main entry point for the Jive Campaign application. Sets up a continuously running loop that
 * checks the latest tweet from the named candidate, translates it to jive, then tweets it as a
 * jivebot.
 *
 */
public class App {

	public static void main(String[] args) throws TwitterException, IOException {
		TwitHelper jivebotDavidCameron = new TwitHelper("David_Cameron", "davidjiveron");
		// TwitHelper jivebotEdMiliband = new TwitHelper("Ed_Miliband", "edjiveaband");
		// TwitHelper jivebotNickClegg = new TwitHelper("nick_clegg", "nickjiveegg");
	}

}
