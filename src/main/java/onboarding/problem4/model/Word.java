package onboarding.problem4.model;

import onboarding.problem4.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        return Pattern.matches("^[ㄱ-ㅎ가-힣]*$", input);
    }

    private Character changeCharacter(Character c) {
        if (Character.isAlphabetic(c)) {
            return changeAlphabeticCharacter(c);
        }
        return c;
    }

    private Character changeAlphabeticCharacter(Character c) {
        if (Character.isLowerCase(c)) {
            return (char) (219 - c);
        }
        return (char) (155 - c);
    }

}
