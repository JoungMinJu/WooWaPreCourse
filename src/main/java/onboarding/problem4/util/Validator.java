package onboarding.problem4.util;

import static onboarding.problem4.util.Constants.LENGTH_ERROR_MESSAGE;

public class Validator {

    public static void validateWords(String input){
        validateLength(input);
    }

    private static void validateLength(String input){
        if (input.length() < 1 || input.length() > 1000){
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }
}
