package co.uk.jiveelection.campaign.injection.translator

import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslatorFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TranslatorModule {

    @Provides
    @Singleton
    fun providesInMemoryJiveTranslatorFactory(): InMemoryJiveTranslatorFactory {
        return InMemoryJiveTranslatorFactory()
    }

}
