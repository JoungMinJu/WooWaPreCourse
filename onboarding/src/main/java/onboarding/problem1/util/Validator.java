package onboarding.problem1.util;

import java.util.List;

import static onboarding.problem1.util.Constants.*;

public class Validator {

    public static void validateInput(List<String> lst){
        validateInputSize(lst);
        validateIsNumeric(lst);
    }

    public static void validatePages(List<Integer> pages){
        validateOddAndEven(pages);
        validateContinuous(pages);
    }

    private static void validateOddAndEven(List<Integer> pages){
        if (pages.get(0) % 2 != 1 || pages.get(1) % 2 != 0){
            throw new IllegalArgumentException(EVEN_ODD_ERROR);
        }
    }

    private static void validateContinuous(List<Integer> pages){
        if (pages.get(1) - pages.get(0) != 1){
            throw new IllegalArgumentException(NOT_CONTINUOUS_ERROR);
        }
    }

    private static void validateInputSize(List<String> lst){
        if (lst.size() != 2){
            throw new IllegalArgumentException(NOT_TWO_PAGES_ERROR);
        }
    }

    private static void validateIsNumeric(List<String> lst){
        for (String s : lst) {
            if(!s.chars().allMatch(Character::isDigit)){
                throw new IllegalArgumentException(NOT_NUMERIC_VALUE_ERROR);
            }

        }
    }
}
