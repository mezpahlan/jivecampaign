package co.uk.jiveelection.campaign.jive.ge2017;

import co.uk.jiveelection.campaign.TwitConfig;
import co.uk.jiveelection.campaign.input.twitter.TwitterInput;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import twitter4j.TwitterException;

public class SturgeonJive extends Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator> {

    public SturgeonJive() {
        input = new TwitterInput(this, "NicolaSturgeon", TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN, TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN_SECRET);
        output = new TwitterOutput(this, TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN, TwitConfig.JIVEOLA_STURGEON_ACCESS_TOKEN_SECRET);
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
