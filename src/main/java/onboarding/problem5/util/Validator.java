package onboarding.problem5.util;

import static onboarding.problem5.util.Constants.NUMERIC_ERROR;
import static onboarding.problem5.util.Constants.RANGE_ERROR;

public class Validator {

    public static void validateIsNumeric(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    public static void validateRange(int money){
        if(money < 1 || money > 1000000){
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
