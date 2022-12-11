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
        Change change = getChange();
        List<Integer> result = changeService.getResult(change);
        outputView.printResult(result);
    }

    private Change getChange(){
        while(true) {
            try{
                outputView.printInputGuide();
                String userInput = inputView.getUserInput();
                return changeService.getChange(userInput);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
