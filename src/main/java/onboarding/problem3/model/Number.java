package onboarding.problem3.model;

import onboarding.problem3.util.Validator;

public class Number {
    private final int number;

    public Number(int number){
        Validator.validateRange(number);
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
