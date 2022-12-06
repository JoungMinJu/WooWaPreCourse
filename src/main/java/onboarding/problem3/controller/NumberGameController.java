package onboarding.problem3.controller;

import onboarding.problem3.service.NumberService;
import onboarding.problem3.view.InputView;
import onboarding.problem3.view.OutputView;
import onboarding.problem3.model.Number;

public class NumberGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberService numberService = new NumberService();

    public void run(){
        outputView.printInputGuide();
        Number userNumber = getUserNumber();
        int resultCount = getResultCount(userNumber.getNumber());
        outputView.printResult(resultCount);
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

    private int getResultCount(int number){
        int count = 0;
        for(int n=1; n<=number; n++){
            count += numberService.countThreeSixNine(n);
        }
        return count;
    }
}
