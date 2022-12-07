package onboarding.problem4.util;

public class Validator {

    public static void validateWords(String input){
        validateLength(input);
    }

    private static void validateLength(String input){
        if (input.length() < 1 || input.length() > 1000){
            throw new IllegalArgumentException("[ERROR] word의 길이는 1 이상 1,000 이하여야합니다.");
        }
    }
}
