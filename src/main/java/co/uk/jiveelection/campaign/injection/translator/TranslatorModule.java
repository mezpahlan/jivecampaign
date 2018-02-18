package co.uk.jiveelection.campaign.injection.translator;

import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslatorFactory;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class TranslatorModule {

    @Provides
    @Singleton
    public static InMemoryJiveTranslatorFactory providesInMemoryJiveTranslatorFactory() {
        return new InMemoryJiveTranslatorFactory();
    }

}
