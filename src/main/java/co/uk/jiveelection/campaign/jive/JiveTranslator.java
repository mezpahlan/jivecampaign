package co.uk.jiveelection.campaign.jive;

/**
 * Translator into Jive.
 *
 * Implementations must provide their own Jive mappings.
 */
public interface JiveTranslator {
    String translate(String text);
}
