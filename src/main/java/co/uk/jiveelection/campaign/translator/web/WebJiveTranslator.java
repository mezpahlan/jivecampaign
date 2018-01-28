package co.uk.jiveelection.campaign.translator.web;

import co.uk.jiveelection.campaign.output.twitter.TranslationEntity;
import co.uk.jiveelection.campaign.translator.JiveTranslator;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * Implements a web based JiveTranslator.
 */
public class WebJiveTranslator implements JiveTranslator {

    private static final String JIVE_ENDPOINT = "http://www.cs.utexas.edu/users/jbc/bork/bork.cgi";

    @Override
    public String translate(String text) {
        final RestTemplate restTemplate = new RestTemplate();
        final HashMap<String, String> queryMap = new HashMap<>(2);
        queryMap.put("type", "translator");
        queryMap.put("input", text);

        final String jiveResponse = restTemplate.postForObject(JIVE_ENDPOINT, null, String.class, queryMap);

        final String safeString = StringEscapeUtils.unescapeHtml4(jiveResponse);

        return TextHelper.twitterWorkarounds(safeString);
    }

    @Override
    public String translate(List<TranslationEntity> entities) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (TranslationEntity entity : entities) {
            if (entity.translatable()) {
                final String translate = translate(entity.text());
                stringBuilder.append(translate);
            } else {
                stringBuilder.append(entity.text());
            }
        }

        return stringBuilder.toString();
    }
}
