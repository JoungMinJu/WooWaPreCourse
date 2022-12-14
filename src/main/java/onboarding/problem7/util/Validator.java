package onboarding.problem7.util;

import java.util.regex.Pattern;

public class Validator {

    public static void validateUserName(String name){
        validateUserNameLength(name);
        validateUserNameType(name);
    }

    private static void validateUserNameLength(String name){
        if(name.length() < 1 || name.length() > 30){
            throw new IllegalArgumentException("사용자의 이름은 길이가 1 이상 30 이하여야합니다.");
        }
    }

    private static void validateUserNameType(String name){
        if(!Pattern.matches("^[a-z]*$", name)){
            throw new IllegalArgumentException("사용자의 이름은 소문자로만 구성되어야합니다.");
        }
    }
}
