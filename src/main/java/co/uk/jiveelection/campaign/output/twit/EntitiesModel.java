package co.uk.jiveelection.campaign.output.twit;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EntitiesModel {
    public static EntitiesModel create(int start, int end) {
        return new AutoValue_EntitiesModel(start, end);
    }

    public abstract int start();

    public abstract int end();
}
