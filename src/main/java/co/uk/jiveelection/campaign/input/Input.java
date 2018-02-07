package co.uk.jiveelection.campaign.input;

import co.uk.jiveelection.campaign.output.twitter.TranslationEntity;

import java.util.List;

/**
 * Inputs non Jive strings.
 */
public interface Input<I> {
    List<TranslationEntity> extractEntities(I input);
}
