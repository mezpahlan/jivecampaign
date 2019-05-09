package co.uk.jiveelection.campaign.translator

import co.uk.jiveelection.campaign.output.twitter.TranslationEntity

/**
 * Translator into Jive.
 *
 *
 * Implementations must provide their own Jive mappings.
 */
interface JiveTranslator {
    fun translate(entities: List<TranslationEntity>)
}
