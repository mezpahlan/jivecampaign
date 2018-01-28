package co.uk.jiveelection.campaign.translator.memory;

import co.uk.jiveelection.campaign.output.twitter.EntitiesModel;
import co.uk.jiveelection.campaign.translator.JiveTranslator;
import co.uk.jiveelection.campaign.utils.RegexMatcherModel;

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

    public InMemoryJiveTranslator() {
        jiveMappings = JiveMappings.getInstance();
    }

    @Override
    public String translate(String text) {
        final List<RegexMatcherModel> regexMatchers = new ArrayList<>();

        jiveMappings.forEach((regex, replacement) -> {
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                final String matchedText = matcher.group();
                final RegexMatcherModel regexMatcher = RegexMatcherModel.create(matcher.start(), matcher.end(), matchedText, matchedText.replaceFirst(regex, replacement));
                regexMatchers.add(regexMatcher);
            }
        });

        regexMatchers.sort(Comparator.comparingInt(RegexMatcherModel::start));

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

        regexMatchers.forEach(regexMatcherModel -> {
            sb.append(text.substring(position[0], regexMatcherModel.start()));
            sb.append(regexMatcherModel.replacementText());
            position[0] = regexMatcherModel.end();
        });

        // It is possible that we have made all of the substitutions that we are expecting but we still have some non
        // substitutable characters left in the original text. Add them to the end.
        if (position[0] < text.length()) {
            sb.append(text.substring(position[0]));
        }

        return sb.toString();
    }

    @Override
    public String translate(List<EntitiesModel> entities) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (EntitiesModel entity : entities) {
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
