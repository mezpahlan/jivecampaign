package co.uk.jiveelection.campaign.utils

/**
 * Describes information about a regex match to be accessed outside a matcher loop.
 */

data class RegexEntity(val start: Int, val end: Int, val matchedText: String, val replacementText: String) {

    companion object {
        fun create(start: Int, end: Int, matchedText: String, replacementText: String): RegexEntity {
            return RegexEntity(start, end, matchedText, replacementText)
        }
    }
}
