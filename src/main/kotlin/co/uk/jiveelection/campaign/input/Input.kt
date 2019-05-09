package co.uk.jiveelection.campaign.input

import co.uk.jiveelection.campaign.output.twitter.TranslationEntity

/**
 * Inputs non Jive strings.
 */
interface Input<in I> {
    fun extractEntities(input: I): List<TranslationEntity>
}
