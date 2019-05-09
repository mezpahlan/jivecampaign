package co.uk.jiveelection.campaign.injection.ge2015

import co.uk.jiveelection.campaign.TwitConfig
import co.uk.jiveelection.campaign.input.twitter.TwitterInputFactory
import co.uk.jiveelection.campaign.jive.ge2015.CleggJive
import co.uk.jiveelection.campaign.output.twitter.TwitterOutputFactory
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslatorFactory
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
class CleggModule {

    @Provides
    @Singleton
    fun provideJive(inMemoryJiveTranslatorFactory: InMemoryJiveTranslatorFactory): CleggJive {
        return CleggJive(providesInputFactory(), providesOutputFactory(), inMemoryJiveTranslatorFactory)
    }

    @Provides
    @Singleton
    fun provideTwitterConfiguration(): Configuration {
        return ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.NICK_JIVEGG_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.NICK_JIVEGG_ACCESS_TOKEN_SECRET)
                .build()
    }

    @Provides
    @Singleton
    fun provideRealName(): String {
        return "nick_clegg"
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
