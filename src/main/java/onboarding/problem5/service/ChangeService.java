package onboarding.problem5.service;

import onboarding.problem5.model.Change;
import onboarding.problem5.util.Validator;

import java.util.ArrayList;
import java.util.List;

import static onboarding.problem5.util.Constants.INIT_INDEX;
import static onboarding.problem5.util.Constants.INIT_UNITS;

public class ChangeService {
    List<Integer> units = INIT_UNITS;

    public int getValidateChange(String change){
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
        for(int index = INIT_INDEX; index < units.size(); index++){
            lst.add(getChangeForUnit(change, units.get(index)));
        }
        return lst;
    }

    private int getChangeForUnit(Change change, int unit){
        return change.getChangeForUnit(unit);
    }


}
