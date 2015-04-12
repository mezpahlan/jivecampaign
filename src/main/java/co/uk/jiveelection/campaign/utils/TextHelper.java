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
		if (input.length() > 140) {
			input = input.replaceAll("What it is, Mama!", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll("baaaad", "bad");
		}
		if (input.length() > 140) {
			input = input.replaceAll("sheeit", "shit");
		}
		if (input.length() > 140) {
			input = input.replaceAll("kindun didate", "candidate");
		}
		if (input.length() > 140) {
			input = input.replaceAll("s snatch", "stake");
		}
		if (input.length() > 140) {
			input = input.replaceAll(" Slap mah fro!", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll("down", "up");
		}
		if (input.length() > 140) {
			input = input.replaceAll(" 'S coo', bro.", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll("boogy", "danz");
		}
		// Remove grammar additions
		if (input.length() > 140) {
			input = input.replaceAll("\"", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll("\\?", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll("children", "kidz");
		}
		if (input.length() > 140) {
			input = input.replaceAll("child", "kid");
		}
		// Remove Twitter additions
		if (input.length() > 140) {
			input = input.replaceAll("^RT", "");
		}

		return input.trim();
	}

}
