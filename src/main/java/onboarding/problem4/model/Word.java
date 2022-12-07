package onboarding.problem4.model;

import onboarding.problem4.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Word {
    List<Character> words;

    public Word(String words){
        Validator.validateWords(words);
        this.words = stringToCharList(words);
    }

    private List<Character> stringToCharList(String input){
        return input.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());
    }
}
