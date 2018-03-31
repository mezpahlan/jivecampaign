# Jive Campaign
Backend for all Jive election campaigns. Written in Java.

## Important
Runs as a Spring Boot application

1. Edit the TwitConfig file with your consumer and access keys.

## Deploying to Cloud Foundry

1. Download and install the `cf` command line tool
2. Log into CF
3. `./gradlew clean buildJar`
4. `cf push jivecampaign -p build/libs/jivecampaign-x.y.z.jar`
