package onboarding.problem3.util;

public class Validator {

    public static void validateIsNumeric(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (!Character.isDigit(input.charAt(index))) {
                throw new IllegalArgumentException("[ERROR] 입력하신 문장이 숫자가 아닙니다.");
            }
        }
    }

    public static void validateRange(int input) {
        if (input < 1 || input > 10000) {
            throw new IllegalArgumentException("[ERROR] 입력 숫자는 1 이상 10,000이하여야합니다.");
        }
    }

}
