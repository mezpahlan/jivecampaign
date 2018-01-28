package co.uk.jiveelection.campaign.utils;

import com.google.auto.value.AutoValue;

/**
 * Describes information about a regex match to be accessed outside a matcher loop.
 */
@AutoValue
public abstract class RegexEntity {
    public static RegexEntity create(int start, int end, String matchedText, String replacementText) {
        return new AutoValue_RegexEntity(start, end, matchedText, replacementText);
    }

    public abstract int start();

    public abstract int end();

    public abstract String matchedText();

    public abstract String replacementText();
}
