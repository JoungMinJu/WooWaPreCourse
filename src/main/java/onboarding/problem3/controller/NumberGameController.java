package onboarding.problem3.controller;

import onboarding.problem3.view.InputView;
import onboarding.problem3.view.OutputView;
import onboarding.problem3.model.Number;

public class NumberGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run(){
        outputView.printInputGuide();
        Number userNumber = getUserNumber();
    }

    private Number getUserNumber(){
        while(true){
            try{
                int userNumber = inputView.getUserNumber();
                return new Number(userNumber);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
