package co.uk.jiveelection.campaign.utils;

public class TextHelper {

	/**
	 * Workarounds for the 140 character limit in Twitter
	 * 
	 * @param input The String string that is potentially too long
	 * @return Hopefully a Twitter compliant String
	 */
	public static String twitterWorkarounds(String input) {
		// Remove jive additions
		if (input.length() > 140) {
			input = input.replaceAll(", dig dis:", ":");
		}
		// Remove grammar additions
		if (input.length() > 140) {
			input = input.replaceAll("\"", "");
		}
		// Remove Twitter additions
		if (input.length() > 140) {
			input = input.replaceAll("^RT", "");
		}

		return input.trim();
	}

}
