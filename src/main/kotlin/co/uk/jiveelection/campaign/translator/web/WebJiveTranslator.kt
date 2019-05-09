package co.uk.jiveelection.campaign.translator.web

import co.uk.jiveelection.campaign.jive.Jive
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity
import co.uk.jiveelection.campaign.translator.JiveTranslator
import org.apache.commons.lang3.StringEscapeUtils
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject
import java.util.*

/**
 * Implements a web based JiveTranslator.
 */
class WebJiveTranslator(private val jiveBot: Jive<*, *, *>) : JiveTranslator {

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
        val restTemplate = RestTemplate()
        val queryMap = HashMap<String, String>(2)
        queryMap["type"] = "translator"
        queryMap["input"] = text

        val jiveResponse = restTemplate.postForObject<String>(url = JIVE_ENDPOINT, uriVariables = queryMap)

        val safeString = StringEscapeUtils.unescapeHtml4(jiveResponse)

        return TextHelper.twitterWorkarounds(safeString)
    }

    companion object {

        private const val JIVE_ENDPOINT = "http://www.cs.utexas.edu/users/jbc/bork/bork.cgi"
    }
}
