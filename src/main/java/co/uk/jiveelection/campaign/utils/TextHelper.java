package co.uk.jiveelection.campaign.utils;

public class TextHelper {

	/**
	 * Workarounds for the 140 character limit in Twitter
	 * 
	 * @param input The String string that is potentially too long
	 * @return Hopefully a Twitter compliant String
	 */
	public static String twitterWorkarounds(String input) {
		// Removals		
		if (input.length() > 140) {
			input = input.replaceAll("^RT", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll("\"", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll("\\?", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll("What it is, Mama! ", "");
		}
		if (input.length() > 140) {
			input = input.replaceAll(" Slap mah fro!", "");
		}
		
		
		// Replacements
		if (input.length() > 140) {
			input = input.replaceAll("candun ", "candid");
		}
		if (input.length() > 140) {
			input = input.replaceAll("children", "kidz");
		}
		if (input.length() > 140) {
			input = input.replaceAll("child", "kid");
		}
		if (input.length() > 140) {
			input = input.replaceAll("\\. @", ".@");
		}
		if (input.length() > 140) {
			input = input.replaceAll("kindun didate", "candidate");
		}
		if (input.length() > 140) {
			input = input.replaceAll("s snatch", "stake");
		}
		if (input.length() > 140) {
			input = input.replaceAll("some", "per");
		}
		if (input.length() > 140) {
			input = input.replaceAll("down", "up");
		}
		if (input.length() > 140) {
			input = input.replaceAll("boogy", "danz");
		}
		if (input.length() > 140) {
			input = input.replaceAll("\\bper\\b", "a");
		}
		if (input.length() > 140) {
			input = input.replaceAll("powerful", "hench");
		}
		if (input.length() > 140) {
			input = input.replaceAll("we're", "we");
		}
		if (input.length() > 140) {
			input = input.replaceAll("isn't", "ain't");
		}
		if (input.length() > 140) {
			input = input.replaceAll("finances", "monies");
		}

		return input.trim();
	}

}