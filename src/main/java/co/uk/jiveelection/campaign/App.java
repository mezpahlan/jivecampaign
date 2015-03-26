package co.uk.jiveelection.campaign;

import twitter4j.Status;
import co.uk.jiveelection.campaign.jive.JiveHelper;
import co.uk.jiveelection.campaign.twit.TwitHelper;

/**
 * Hello world!
 *
 */
public class App {

	private static String translateToJive(TwitHelper input) {
		int postition = 0;
		String jive = "";

		for (int i = 0; i < input.entities.size(); i++) {
			String sub = input.statusText.substring(postition, input.entities.get(i).getStart());
			jive += JiveHelper.translateToJive(sub)
					+ " "
					+ input.statusText.substring(input.entities.get(i).getStart(), input.entities
							.get(i).getEnd()) + " ";
			postition = input.entities.get(i).getEnd();
		}

		return jive;

	}

	public static void main(String[] args) {
		TwitHelper twitter = new TwitHelper("twitter");
		TwitHelper davidCameron = new TwitHelper("David_Cameron");
		TwitHelper edMiliband = new TwitHelper("Ed_Miliband");
		TwitHelper nickClegg = new TwitHelper("nick_clegg");

		System.out.println(translateToJive(davidCameron));
		System.out.println(translateToJive(edMiliband));
		System.out.println(translateToJive(nickClegg));
		

	}
}
