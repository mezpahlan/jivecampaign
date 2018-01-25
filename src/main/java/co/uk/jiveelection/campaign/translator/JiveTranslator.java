package co.uk.jiveelection.campaign.translator;

/**
 * Translator into Jive.
 *
 * Implementations must provide their own Jive mappings.
 */
public interface JiveTranslator {
    String translate(String text);
}
