package co.uk.jiveelection.campaign.jive.ge2017;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.input.twitter.TwitterInput;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import twitter4j.TwitterException;

public class MayJive extends Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator> {

    public MayJive() {
        input = new TwitterInput(this, "theresa_may", TwitConfig.JIVERESA_MAY_ACCESS_TOKEN, TwitConfig.JIVERESA_MAY_ACCESS_TOKEN_SECRET);
        output = new TwitterOutput(this, TwitConfig.JIVERESA_MAY_ACCESS_TOKEN, TwitConfig.JIVERESA_MAY_ACCESS_TOKEN_SECRET);
        translator = new InMemoryJiveTranslator(this);
    }

    @Override
    public void init() throws TwitterException {
        input.init();
    }

    @Override
    public void onJiveComplete(Object o) {
        // Do nothing for now.
    }
}
