package onboarding.problem5.service;

import onboarding.problem5.model.Change;
import onboarding.problem5.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class ChangeService {
    List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

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

    public List<Integer> getResult(Change change){
        List<Integer> lst = new ArrayList<>();
        for(int index = 0; index < units.size(); index++){
            lst.add(getChangeForUnit(change, units.get(index)));
        }
        return lst;
    }

    private int getChangeForUnit(Change change, int unit){
        return change.getChangeForUnit(unit);
    }


}
