package co.uk.jiveelection.campaign.output.twitter

/**
 * Describes information about a TwitterEntity.
 */
data class TranslationEntity(val start: Int, val end: Int, val text: String, val translatable: Boolean) {

    companion object {
        fun translate(start: Int, end: Int, text: String): TranslationEntity {
            return TranslationEntity(start, end, text, true)
        }

        fun verbatim(start: Int, end: Int, text: String): TranslationEntity {
            return TranslationEntity(start, end, text, false)
        }
    }
}
