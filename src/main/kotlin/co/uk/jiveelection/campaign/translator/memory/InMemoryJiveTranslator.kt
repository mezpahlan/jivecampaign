package co.uk.jiveelection.campaign.translator.memory

import co.uk.jiveelection.campaign.jive.Jive
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity
import co.uk.jiveelection.campaign.translator.JiveTranslator
import co.uk.jiveelection.campaign.utils.RegexEntity
import com.google.auto.factory.AutoFactory
import java.util.*
import java.util.regex.Pattern

/**
 * Implements an in memory JiveTranslator.
 */
@AutoFactory
class InMemoryJiveTranslator(private val jiveBot: Jive<*, *, *>) : JiveTranslator {

    private val jiveMappings: JiveMappings = JiveMappings.instance

    override fun translate(entities: List<TranslationEntity>) {
        val stringBuilder = StringBuilder()

        for (entity in entities) {
            if (entity.translatable) {
                val translate = processString(entity.text)
                stringBuilder.append(translate)
            } else {
                stringBuilder.append(entity.text)
            }
        }

        jiveBot.onTranslationComplete(stringBuilder.toString())
    }

    private fun processString(text: String): String {
        val regexMatchers = ArrayList<RegexEntity>()

        jiveMappings.map.forEach { (regex, replacement) ->
            val pattern = Pattern.compile(regex)
            val matcher = pattern.matcher(text)
            while (matcher.find()) {
                val matchedText = matcher.group()
                val regexMatcher = RegexEntity.create(matcher.start(), matcher.end(), matchedText, matchedText.replaceFirst(regex.toRegex(), replacement))
                regexMatchers.add(regexMatcher)
            }
        }

        regexMatchers.sortBy { it.start }

        val lengthOfRemovedTexts = regexMatchers
                .stream()
                .mapToInt { m -> m.matchedText.length }
                .sum()

        val lengthOfReplacementTexts = regexMatchers
                .stream()
                .mapToInt { m -> m.replacementText.length }
                .sum()

        val bufferSize = text.length - lengthOfRemovedTexts + lengthOfReplacementTexts + 1

        val sb = StringBuilder(bufferSize)
        val position = intArrayOf(0)

        regexMatchers.forEach { regexEntity ->
            sb.append(text, position[0], regexEntity.start)
            sb.append(regexEntity.replacementText)
            position[0] = regexEntity.end
        }

        // It is possible that we have made all of the substitutions that we are expecting but we still have some non
        // substitutable characters left in the original text. Add them to the end.
        if (position[0] < text.length) {
            sb.append(text.substring(position[0]))
        }

        return sb.toString()
    }
}
