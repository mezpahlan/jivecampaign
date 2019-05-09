package co.uk.jiveelection.campaign.jive

import co.uk.jiveelection.campaign.input.Input
import co.uk.jiveelection.campaign.output.Output
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity
import co.uk.jiveelection.campaign.translator.JiveTranslator

/**
 * Abstract Jive Campaign bot.
 *
 * @param <I>  Input:
 * @param <O>  Output:
 * @param <JT> JiveTranslator:
</JT></O></I> */
abstract class Jive<out I : Input<*>, out O : Output<*>, out JT : JiveTranslator> {

    abstract val input: I
    abstract val output: O
    abstract val translator: JT

    @Throws(Exception::class)
    abstract fun init()

    fun onInputReceived(translationEntities: List<TranslationEntity>) {
        translator.translate(translationEntities)
    }

    fun onTranslationComplete(jive: String) {
        output.outputJive(jive)
    }

    abstract fun onJiveComplete(o: Any)
}