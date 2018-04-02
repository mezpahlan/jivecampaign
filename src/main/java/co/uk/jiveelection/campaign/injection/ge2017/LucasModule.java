package co.uk.jiveelection.campaign.injection.ge2017;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.injection.translator.TranslatorModule;
import co.uk.jiveelection.campaign.input.twitter.TwitterInputFactory;
import co.uk.jiveelection.campaign.jive.ge2017.LucasJive;
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
public class LucasModule {

    @Provides
    @Singleton
    public static LucasJive provideJive() {
        return new LucasJive(providesInputFactory(), providesOutputFactory(), TranslatorModule.providesInMemoryJiveTranslatorFactory());
    }

    @Provides
    @Singleton
    public static Configuration provideConfiguration() {
        return new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .setOAuthAccessToken(TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TwitConfig.JIVEOLINE_LUCAS_ACCESS_TOKEN_SECRET)
                .build();
    }

    @Provides
    public static String provideRealName() {
        return "CarolineLucas";
    }

    @Provides
    @Singleton
    public static Twitter providesTwitter() {
        return new TwitterFactory(provideConfiguration()).getInstance();
    }

    @Provides
    @Singleton
    public static TwitterStream providesTwitterStream() {
        return new TwitterStreamFactory(provideConfiguration()).getInstance();
    }

    @Provides
    @Singleton
    public static TwitterInputFactory providesInputFactory() {
        return new TwitterInputFactory(LucasModule::provideRealName, LucasModule::providesTwitter, LucasModule::providesTwitterStream);
    }

    @Provides
    @Singleton
    public static TwitterOutputFactory providesOutputFactory() {
        return new TwitterOutputFactory(LucasModule::providesTwitter);
    }
}
