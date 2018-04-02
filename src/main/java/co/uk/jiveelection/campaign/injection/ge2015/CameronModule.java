package co.uk.jiveelection.campaign.injection.ge2015;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.injection.translator.TranslatorModule;
import co.uk.jiveelection.campaign.input.twitter.TwitterInputFactory;
import co.uk.jiveelection.campaign.jive.ge2015.CameronJive;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutputFactory;
import dagger.Module;
import dagger.Provides;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import javax.inject.Singleton;

@Module
public class CameronModule {

    @Provides
    @Singleton
    public static CameronJive provideJive() {
        return new CameronJive(providesInputFactory(), providesOutputFactory(), TranslatorModule.providesInMemoryJiveTranslatorFactory());
    }

    @Provides
    @Singleton
    public static Configuration provideTwitterConfiguration() {
        return new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.DAVID_JIVERON_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.DAVID_JIVERON_ACCESS_TOKEN_SECRET)
                .build();
    }

    @Provides
    public static String provideRealName() {
        return "David_Cameron";
    }

    @Provides
    @Singleton
    public static Twitter providesTwitter() {
        return new TwitterFactory(provideTwitterConfiguration()).getInstance();
    }

    @Provides
    @Singleton
    public static TwitterStream providesTwitterStream() {
        return new TwitterStreamFactory(provideTwitterConfiguration()).getInstance();
    }

    @Provides
    @Singleton
    public static TwitterInputFactory providesInputFactory() {
        return new TwitterInputFactory(CameronModule::provideRealName, CameronModule::providesTwitter, CameronModule::providesTwitterStream);
    }

    @Provides
    @Singleton
    public static TwitterOutputFactory providesOutputFactory() {
        return new TwitterOutputFactory(CameronModule::providesTwitter);
    }
}
