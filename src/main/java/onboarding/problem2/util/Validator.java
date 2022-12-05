package onboarding.problem2.util;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static onboarding.problem1.util.Constants.NOT_NUMERIC_VALUE_ERROR;

public class Validator {

    public static void validateCryptogram(String cryptogram){
        validateLength(cryptogram);
        validateType(cryptogram);
    }

    private static void validateLength(String cryptogram){
        if (cryptogram.length() <= 0 || cryptogram.length() > 1000){
            throw new IllegalArgumentException(
                    String.format("[ERROR] 암호문의 길이는 %d이상 %d이하 입니다.", 1, 1000));
        }
    }


    private static void validateType(String cryptogram){
        if (!Pattern.matches("^[a-z]*$", cryptogram)){
            throw new IllegalArgumentException("[ERROR] 암호문은 소문자로만 구성되어야 합니다.");
        }
    }
}
