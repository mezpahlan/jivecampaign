package co.uk.jiveelection.campaign.translator.web;

public class TextHelper {
    
    public static final int TWEET_LIMIT = 280;

    /**
     * Workarounds for the Twitter character limit.
     *
     * @param input The String string that is potentially too long
     * @return Hopefully a Twitter compliant String
     */
    public static String twitterWorkarounds(String input) {
        // Removals
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("^RT", "");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("\"", "");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("\\?", "");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("What it is, Mama! ", "");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll(" Slap mah fro!", "");
        }


        // Replacements
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("candun ", "candid");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("children", "kidz");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("child", "kid");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("\\. @", ".@");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("kindun didate", "candidate");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("s snatch", "stake");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("some", "per");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("down", "up");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("boogy", "danz");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("\\bper\\b", "a");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("powerful", "hench");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("we're", "we");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("isn't", "ain't");
        }
        if (input.length() > TWEET_LIMIT) {
            input = input.replaceAll("finances", "monies");
        }

        return input.trim();
    }

}