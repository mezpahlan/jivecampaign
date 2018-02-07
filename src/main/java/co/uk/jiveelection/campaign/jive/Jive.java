package co.uk.jiveelection.campaign.jive;

import co.uk.jiveelection.campaign.input.Input;
import co.uk.jiveelection.campaign.output.Output;
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity;
import co.uk.jiveelection.campaign.translator.JiveTranslator;

import java.util.List;

/**
 * Abstract Jive Campaign bot.
 *
 * @param <I>  Input:
 * @param <O>  Output:
 * @param <JT> JiveTranslator:
 */
public abstract class Jive<I extends Input, O extends Output, JT extends JiveTranslator> {

    protected I input;
    protected O output;
    protected JT translator;

    public abstract void init() throws Exception;

    public void onInputReceived(List<TranslationEntity> translationEntities) {
        translator.translate(translationEntities);
    }

    public void onTranslationComplete(String jive) {
        output.outputJive(jive);
    }

    public abstract void onJiveComplete(Object o);
}