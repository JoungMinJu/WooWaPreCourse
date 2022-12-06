package onboarding.problem3.service;

import static onboarding.problem3.util.Constants.*;

public class NumberService {

    public int countThreeSixNine(int number){
        int count = 0;
        String numberString = String.valueOf(number);
        for(int index = 0; index < numberString.length(); index++){
            count += getDigitNumberCount(numberString.charAt(index));
        }
        return count;
    }

    private int getDigitNumberCount(char numberInput){
        int number = numberInput - '0';
        if (isThreeSixNine(number)){
            return 1;
        }
        return 0;
    }

    private boolean isThreeSixNine(int number){
        return number == FIRST_COUNT_INT || number == SECOND_COUNT_INT || number == THIRD_COUNT_INT;
    }
}
