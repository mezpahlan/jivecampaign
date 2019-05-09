package co.uk.jiveelection.campaign.injection.ge2017

import co.uk.jiveelection.campaign.TwitConfig
import co.uk.jiveelection.campaign.injection.translator.TranslatorModule
import co.uk.jiveelection.campaign.input.twitter.TwitterInputFactory
import co.uk.jiveelection.campaign.jive.ge2017.WoodJive
import co.uk.jiveelection.campaign.output.twitter.TwitterOutputFactory
import dagger.Module
import dagger.Provides
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.TwitterStream
import twitter4j.TwitterStreamFactory
import twitter4j.conf.Configuration
import twitter4j.conf.ConfigurationBuilder
import javax.inject.Provider
import javax.inject.Singleton

@Module
object WoodModule {

    @Provides
    @Singleton
    fun provideJive(): WoodJive {
        return WoodJive(providesInputFactory(), providesOutputFactory(), TranslatorModule.providesInMemoryJiveTranslatorFactory())
    }

    @Provides
    @Singleton
    fun provideConfiguration(): Configuration {
        return ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.JIVEANNE_WOOD_ACCESS_TOKEN_SECRET)
                .build()
    }

    @Provides
    @Singleton
    fun provideRealName(): String {
        return "LeanneWood"
    }

    @Provides
    @Singleton
    fun providesTwitter(): Twitter {
        return TwitterFactory(provideConfiguration()).instance
    }

    @Provides
    @Singleton
    fun providesTwitterStream(): TwitterStream {
        return TwitterStreamFactory(provideConfiguration()).instance
    }

    @Provides
    @Singleton
    fun providesInputFactory(): TwitterInputFactory {
        return TwitterInputFactory(Provider<String> { provideRealName() }, Provider<Twitter> { providesTwitter() }, Provider<TwitterStream> { providesTwitterStream() })
    }

    @Provides
    @Singleton
    fun providesOutputFactory(): TwitterOutputFactory {
        return TwitterOutputFactory(Provider<Twitter> { providesTwitter() })
    }
}
