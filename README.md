# Jive Campaign
Backend for all Jive election campaigns. Written in Java.

## Important
You need the following for this to work.

1. An environment variable OPENSHIFT_DATA_DIR set to the directory where your properties files are.
2. Properties files from Twitter.
	For your Twitter app, placed in `twitter4j.properties`. `oauth.consumerKey` and `oauth.consumerSecret`.
	For each of your Jive Bots, placed in `<jivebotname>.properties`. `accessToken` and `accessTokenSecret`.
