package onboarding.problem1.util;

import java.util.List;

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
            throw new IllegalArgumentException("[ERROR] 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야합니다.");
        }
    }

    private static void validateContinuous(List<Integer> pages){
        if (pages.get(1) - pages.get(0) != 1){
            throw new IllegalArgumentException("[ERROR] 연속되는 페이지여야합니다.");
        }
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
