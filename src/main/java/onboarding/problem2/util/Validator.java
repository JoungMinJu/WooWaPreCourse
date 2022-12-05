package onboarding.problem2.util;

import java.util.regex.Pattern;

import static onboarding.problem2.util.Constants.*;

public class Validator {

    public static void validateCryptogram(String cryptogram) {
        validateLength(cryptogram);
        validateType(cryptogram);
    }

    private static void validateLength(String cryptogram) {
        if (cryptogram.length() <= 0 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException(
                    String.format(LENGTH_ERROR, MIN_LENGTH, MAX_LENGTH));
        }
    }


    private static void validateType(String cryptogram) {
        if (!Pattern.matches(VALIDATE_TYPE_REGEX, cryptogram)) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }
}
