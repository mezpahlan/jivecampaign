package co.uk.jiveelection.campaign.output.twitter;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EntitiesModel {
    public static EntitiesModel translate(int start, int end, String text) {
        return new AutoValue_EntitiesModel(start, end, text, true);
    }

    public static EntitiesModel verbatim(int start, int end, String text) {
        return new AutoValue_EntitiesModel(start, end, text, false);
    }

    public abstract int start();

    public abstract int end();

    public abstract String text();

    public abstract boolean translatable();
}
