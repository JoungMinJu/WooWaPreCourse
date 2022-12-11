package onboarding.problem5.service;

import onboarding.problem5.model.Change;
import onboarding.problem5.util.Validator;

public class ChangeService {

    public Change getChange(String input){
        while(true){
            try{
                int change = getValidateChange(input);
                return new Change(change);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidateChange(String change){
        int changeInt = changeStringToInt(change);
        Validator.validateRange(changeInt);
        return changeInt;
    }

    private int changeStringToInt(String change){
        Validator.validateIsNumeric(change);
        return Integer.parseInt(change);
    }


}
