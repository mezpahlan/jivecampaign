package co.uk.jiveelection.campaign.utils;

import com.google.auto.value.AutoValue;

/**
 * Describes information about a regex match to be accessed outside a matcher loop.
 */
@AutoValue
public abstract class RegexMatcherModel {
    public abstract int start();

    public abstract int end();

    public abstract String matchedText();

    public abstract String replacementText();

    public static Builder builder() {
        return new AutoValue_RegexMatcherModel.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setStart(int value);

        public abstract Builder setEnd(int value);

        public abstract Builder setMatchedText(String value);

        public abstract Builder setReplacementText(String value);

        public abstract RegexMatcherModel build();
    }
}
