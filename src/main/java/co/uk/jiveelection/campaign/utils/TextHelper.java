package co.uk.jiveelection.campaign.utils;

public class TextHelper {

	/**
	 * Workarounds for the 140 character limit in Twitter
	 * @param input The String string that is potentially too long
	 * @return output Hopefully a Twitter compliant String
	 */
	public static String twitterWorkarounds(String input) {
		String output = input.replaceAll(", dig dis:", ":");
		return output.trim();
	}
	
}
