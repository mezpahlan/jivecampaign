package co.uk.jiveelection.campaign.utils;

import co.uk.jiveelection.campaign.TwitConfig;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class AuthorisationHelper {

    /**
     * In order to authorise our app for reading and writing to the translator accounts we must first do
     * some set up. Twitter requires you to receive an access token that allows reading and writing
     * on behalf on another user. This is what we are going to use and will generate here.
     * <p>
     * To get the access token you first need a temporary request token. Once this is received you
     * can get authorise the app against the translator accounts. Sign into Twitter with the translator account,
     * follow the url from the console whilst debugging this file, authorise Jive Tweeter. The call
     * back will fail because we haven't set up a website yet. But it will display an oauth_verifier
     * parameter in the address bar of the browser. Copy this and set verifier to this value.
     * <p>
     * You will now have the access token be sure to copy the values for accessToken and
     * accessTokenSecret and put them in the configuration file. You must do this immediately because
     * this code is not idempotent.
     */
    public static void main(String[] args) throws TwitterException {
        Configuration configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitConfig.CONSUMER_TOKEN)
                .setOAuthConsumerSecret(TwitConfig.CONSUMER_TOKEN_SECRET)
                .build();

        // The factory instance is re-useable and thread safe.
        Twitter twitter = new TwitterFactory(configuration).getInstance();

        // Temp request token only needed once.
        RequestToken requestToken = twitter.getOAuthRequestToken();

        // Set up empty access token.
        AccessToken accessToken = null;

        // Follow the console instructions whilst you are signed into the translator account on Twitter
        System.out.println("Open the following URL and grant access to your account:");
        System.out.println(requestToken.getAuthorizationURL());

        // Break point below this line!! and change the value of verifier.
        String verifier = "";
        try {
            accessToken = twitter.getOAuthAccessToken(verifier);
        } catch (TwitterException te) {
            if (401 == te.getStatusCode()) {
                System.out.println("Unable to get the access token.");
            } else {
                te.printStackTrace();
            }
        }
        // Break point below this line!! And grab the credentials from the accessToken object.
        boolean yes = true;

    }

}
