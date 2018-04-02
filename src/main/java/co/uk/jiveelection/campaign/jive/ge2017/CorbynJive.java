package co.uk.jiveelection.campaign.jive.ge2017;

import co.uk.jiveelection.campaign.input.twitter.TwitterInput;
import co.uk.jiveelection.campaign.input.twitter.TwitterInputFactory;
import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutput;
import co.uk.jiveelection.campaign.output.twitter.TwitterOutputFactory;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslator;
import co.uk.jiveelection.campaign.translator.memory.InMemoryJiveTranslatorFactory;
import twitter4j.TwitterException;

import javax.inject.Inject;

public class CorbynJive extends Jive<TwitterInput, TwitterOutput, InMemoryJiveTranslator> {

    @Inject
    public CorbynJive(TwitterInputFactory twitterInputFactory, TwitterOutputFactory twitterOutputFactory, InMemoryJiveTranslatorFactory inMemoryJiveTranslatorFactory) {
        input = twitterInputFactory.create(this);
        output = twitterOutputFactory.create(this);
        translator = inMemoryJiveTranslatorFactory.create(this);
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
