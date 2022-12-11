package onboarding.problem5.util;

public class Validator {

    public static void validateIsNumeric(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야합니다.");
        }
    }

    public static void validateRange(int money){
        if(money < 1 || money > 1000000){
            throw new IllegalArgumentException("[ERROR] 금액은 1원 이상 1,000,000원 이하여야합니다.");
        }
    }
}
