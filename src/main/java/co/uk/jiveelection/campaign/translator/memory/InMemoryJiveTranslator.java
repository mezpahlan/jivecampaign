package co.uk.jiveelection.campaign.translator.memory;

import co.uk.jiveelection.campaign.jive.Jive;
import co.uk.jiveelection.campaign.output.twitter.TranslationEntity;
import co.uk.jiveelection.campaign.translator.JiveTranslator;
import co.uk.jiveelection.campaign.utils.RegexEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements an in memory JiveTranslator.
 */
public class InMemoryJiveTranslator implements JiveTranslator {

    private final JiveMappings jiveMappings;
    private final Jive jiveBot;

    public InMemoryJiveTranslator(Jive jiveBot) {
        this.jiveBot = jiveBot;
        jiveMappings = JiveMappings.getInstance();
    }

    @Override
    public void translate(List<TranslationEntity> entities) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (TranslationEntity entity : entities) {
            if (entity.translatable()) {
                final String translate = processString(entity.text());
                stringBuilder.append(translate);
            } else {
                stringBuilder.append(entity.text());
            }
        }

        jiveBot.onTranslationComplete(stringBuilder.toString());
    }

    private String processString(String text) {
        final List<RegexEntity> regexMatchers = new ArrayList<>();

        jiveMappings.forEach((regex, replacement) -> {
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                final String matchedText = matcher.group();
                final RegexEntity regexMatcher = RegexEntity.create(matcher.start(), matcher.end(), matchedText, matchedText.replaceFirst(regex, replacement));
                regexMatchers.add(regexMatcher);
            }
        });

        regexMatchers.sort(Comparator.comparingInt(RegexEntity::start));

        final int lengthOfRemovedTexts = regexMatchers
                .stream()
                .mapToInt(m -> m.matchedText().length())
                .sum();

        final int lengthOfReplacementTexts = regexMatchers
                .stream()
                .mapToInt(m -> m.replacementText().length())
                .sum();

        final int bufferSize = (text.length() - lengthOfRemovedTexts) + lengthOfReplacementTexts + 1;

        final StringBuilder sb = new StringBuilder(bufferSize);
        final int[] position = {0};

        regexMatchers.forEach(regexEntity -> {
            sb.append(text.substring(position[0], regexEntity.start()));
            sb.append(regexEntity.replacementText());
            position[0] = regexEntity.end();
        });

        // It is possible that we have made all of the substitutions that we are expecting but we still have some non
        // substitutable characters left in the original text. Add them to the end.
        if (position[0] < text.length()) {
            sb.append(text.substring(position[0]));
        }

        return sb.toString();
    }
}
