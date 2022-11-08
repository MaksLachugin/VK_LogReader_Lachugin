package ru.vk.word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexWord extends AnyWord  {

    Pattern pattern;

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }


    public RegexWord(String reg) {
        super(reg);
        pattern = getReg(getWord());
    }

    private static Pattern getReg(String str) {
        try {
            return Pattern.compile(str);

        } catch (PatternSyntaxException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    @Override
    public boolean isExists(String line) {
        if (pattern == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.start() == 0 && matcher.end() == line.length()) {
                return true;
            }
        }
        return false;

    }
}
