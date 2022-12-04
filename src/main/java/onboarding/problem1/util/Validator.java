package onboarding.problem1.util;

import java.util.List;

public class Validator {

    public static void validateInput(List<String> lst){
        validateInputSize(lst);
        validateIsNumeric(lst);
    }

    private static void validateInputSize(List<String> lst){
        if (lst.size() != 2){
            throw new IllegalArgumentException("[ERROR] 총 페이지는 두 개 입력되어야 합니다.");
        }
    }

    private static void validateIsNumeric(List<String> lst){
        for (String s : lst) {
            if(!s.chars().allMatch(Character::isDigit)){
                throw new IllegalArgumentException("[ERROR] 페이지 번호는 숫자여야합니다.");
            }

        }
    }
}
