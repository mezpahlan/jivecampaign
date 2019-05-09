package co.uk.jiveelection.campaign.injection.ge2015

import co.uk.jiveelection.campaign.TwitConfig
import co.uk.jiveelection.campaign.injection.translator.TranslatorModule
import co.uk.jiveelection.campaign.input.twitter.TwitterInputFactory
import co.uk.jiveelection.campaign.jive.ge2015.MilibandJive
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
object MilibandModule {

    @Provides
    @Singleton
    fun provideJive(): MilibandJive {
        return MilibandJive(providesInputFactory(), providesOutputFactory(), TranslatorModule.providesInMemoryJiveTranslatorFactory())
    }

    @Provides
    @Singleton
    fun provideTwitterConfiguration(): Configuration {
        return ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.ED_JIVEABAND_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.ED_JIVEABAND_ACCESS_TOKEN_SECRET)
                .build()
    }

    @Provides
    @Singleton
    fun provideRealName(): String {
        return "Ed_Miliband"
    }

    @Provides
    @Singleton
    fun providesTwitter(): Twitter {
        return TwitterFactory(provideTwitterConfiguration()).instance
    }

    @Provides
    @Singleton
    fun providesTwitterStream(): TwitterStream {
        return TwitterStreamFactory(provideTwitterConfiguration()).instance
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
