package onboarding.problem1.view;

import camp.nextstep.edu.missionutils.Console;
import onboarding.problem1.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<Integer> getUserInputPages(){
        String userInput = getUserInput();
        List<String> strings = Arrays.asList(userInput.split(" "));
        Validator.validateInput(strings);
        return stringToIntegerList(strings);
    }

    private String getUserInput(){
        return Console.readLine();
    }

    private List<Integer> stringToIntegerList(List<String> input){
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
