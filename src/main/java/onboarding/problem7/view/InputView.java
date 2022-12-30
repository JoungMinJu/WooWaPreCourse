package onboarding.problem7.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public String getUserInput(){
        return Console.readLine();
    }

    public int getIntUserInput(){
        try{
            String userInput = getUserInput();
            return Integer.parseInt(userInput);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("친구 목록의 사이즈는 숫자여야합니다.");
        }
    }

    public List<String> getRelationNames(){
        return List.of(getUserInput().split(" "));
    }

    public List<String> getVisitors(){
        return List.of(getUserInput().split(" "));
    }
}
