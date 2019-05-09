package co.uk.jiveelection.campaign.translator.web

object TextHelper {

    private const val TWEET_LIMIT = 280

    /**
     * Workarounds for the Twitter character limit.
     *
     * @param input The String string that is potentially too long
     * @return Hopefully a Twitter compliant String
     */
    fun twitterWorkarounds(input: String): String {
        var output = input
        // Removals
        if (output.length > TWEET_LIMIT) {
            output = output.replace("^RT".toRegex(), "")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("\"".toRegex(), "")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("\\?".toRegex(), "")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("What it is, Mama! ".toRegex(), "")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace(" Slap mah fro!".toRegex(), "")
        }


        // Replacements
        if (output.length > TWEET_LIMIT) {
            output = output.replace("candun ".toRegex(), "candid")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("children".toRegex(), "kidz")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("child".toRegex(), "kid")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("\\. @".toRegex(), ".@")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("kindun didate".toRegex(), "candidate")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("s snatch".toRegex(), "stake")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("some".toRegex(), "per")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("down".toRegex(), "up")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("boogy".toRegex(), "danz")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("\\bper\\b".toRegex(), "a")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("powerful".toRegex(), "hench")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("we're".toRegex(), "we")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("isn't".toRegex(), "ain't")
        }
        if (output.length > TWEET_LIMIT) {
            output = output.replace("finances".toRegex(), "monies")
        }

        return output.trim { it <= ' ' }
    }

}