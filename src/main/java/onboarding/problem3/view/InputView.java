package onboarding.problem3.view;

import camp.nextstep.edu.missionutils.Console;
import onboarding.problem3.util.Validator;

public class InputView {

    public int getUserNumber(){
        String userInput = getUserInput();
        Validator.validateIsNumeric(userInput);
        return Integer.parseInt(userInput);
    }

    private String getUserInput(){
        return Console.readLine();
    }

}
