package co.uk.jiveelection.campaign.translator;

import co.uk.jiveelection.campaign.output.twitter.TranslationEntity;

import java.util.List;

/**
 * Translator into Jive.
 * <p>
 * Implementations must provide their own Jive mappings.
 */
public interface JiveTranslator {
    String translate(String text);

    String translate(List<TranslationEntity> entities);
}
