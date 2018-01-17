package co.uk.jiveelection.campaign.jive;

import co.uk.jiveelection.campaign.utils.RegexMatcherModel;
import org.springframework.util.StringUtils;

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
                final RegexMatcherModel.Builder builder = RegexMatcherModel.builder()
                        .setStart(matcher.start())
                        .setEnd(matcher.end())
                        .setMatchedText(matchedText)
                        .setReplacementText(matchedText.replaceFirst(regex, replacement));
                regexMatchers.add(builder.build());
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

        return StringUtils.trimTrailingWhitespace(sb.toString());
    }
}
