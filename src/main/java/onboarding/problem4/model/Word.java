package onboarding.problem4.model;

import onboarding.problem4.util.Validator;

import java.util.List;
import java.util.regex.Pattern;

import static onboarding.problem4.util.Constants.*;

public class Word {
    List<String> words;

    public Word(String words) {
        Validator.validateWords(words);
        this.words = List.of(words.split(""));
    }

    public String getChangedWord() {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(getChangedCharacter(word));
        }
        return sb.toString();
    }

    private String getChangedCharacter(String input) {
        if (isKorean(input)) {
            return input;
        }
        char inputChar = input.charAt(0);
        return changeCharacter(inputChar).toString();
    }

    private boolean isKorean(String input) {
        return Pattern.matches(KOREAN_REGEX, input);
    }

    private Character changeCharacter(Character c) {
        if (Character.isAlphabetic(c)) {
            return changeAlphabeticCharacter(c);
        }
        return c;
    }

    private Character changeAlphabeticCharacter(Character c) {
        if (Character.isLowerCase(c)) {
            return (char) (LOWER_CASE_CHANGE_VALUE - c);
        }
        return (char) (UPPER_CASE_CHANGE_VALUE - c);
    }

}
