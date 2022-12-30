package onboarding.problem5.controller;

import onboarding.problem5.model.Change;
import onboarding.problem5.service.ChangeService;
import onboarding.problem5.view.InputView;
import onboarding.problem5.view.OutputView;

import java.util.List;

public class ChangeController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ChangeService changeService = new ChangeService();

    public void run() {
        outputView.printInputGuide();
        Change change = getChange();
        List<Integer> result = changeService.getResult(change);
        outputView.printResult(result);
    }

    private Change getChange(){
        while(true) {
            try{
                String userInput = inputView.getUserInput();
                int validateChange = changeService.getValidateChange(userInput);
                return new Change(validateChange);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
