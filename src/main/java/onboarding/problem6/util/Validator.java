package onboarding.problem6.util;

import java.util.List;
import java.util.regex.Pattern;

import static onboarding.problem6.util.Constants.*;

public class Validator {

    public static void validateNumberOfPerson(List<String> input){
        if(input.size() < MIN_NUMBER_OF_PERSON || input.size() > MAX_NUMBER_OF_PERSON){
            throw new IllegalArgumentException(PERSON_NUMBER_ERROR);
        }
    }

    public static void validateNumberOfPersonParam(List<String> input){
        if(input.size() != 2){
            throw new IllegalArgumentException(PARAMETER_NUMBER_ERROR);
        }
    }

    public static void validateEmail(String input){
        validateEmailLength(input);
        validateEmailForm(input);
    }

    private static void validateEmailForm(String input){
        String[] split = input.split(EMAIL_SEPARATOR);
        if( split.length != 2){
            throw new IllegalArgumentException(EMAIL_FORM_ERROR);
        }
        if(!split[DOMAIN_INDEX].equals(VALID_EMAIL_DOMAIN)){
            throw new IllegalArgumentException(EMAIL_DOMAIN_ERROR);
        }
    }

    private static void validateEmailLength(String input){
        if(input.length() < MIN_LENGTH_OF_EMAIL || input.length() >= MAX_LENGTH_OF_EMAIL){
            throw new IllegalArgumentException(EMAIL_LENGTH_ERROR);
        }
    }

    public static void validateNickname(String input){
        validateNickNameLength(input);
        validateNicknameForm(input);
    }

    private static void validateNicknameForm(String input){
        if(!Pattern.matches(KOREAN_REGEX, input)){
            throw new IllegalArgumentException(NICKNAME_TYPE_ERROR);
        }
    }

    private static void validateNickNameLength(String input){
        if(input.length() < MIN_LENGTH_OF_NICKNAME || input.length() >= MAX_LENGTH_OF_NICKNAME){
            throw new IllegalArgumentException(NICKNAME_LENGTH_ERROR);
        }
    }

}
