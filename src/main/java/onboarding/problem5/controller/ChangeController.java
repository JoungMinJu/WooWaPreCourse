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
        String userInput = inputView.getUserInput();
        Change change = changeService.getChange(userInput);
        List<Integer> result = changeService.getResult(change);
        outputView.printResult(result);
    }
}
