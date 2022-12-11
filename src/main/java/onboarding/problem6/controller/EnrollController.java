package onboarding.problem6.controller;

import onboarding.problem6.model.Person;
import onboarding.problem6.service.EnrollService;
import onboarding.problem6.view.InputView;
import onboarding.problem6.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class EnrollController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    EnrollService enrollService = new EnrollService();

    public void run(){
        outputView.printInputGuide();
        List<Person> persons = getPersons();

    }

    private List<Person> getPersons(){
        while(true){
            try{
                String userInput = inputView.getUserInput();
                return enrollService.getPersons(userInput);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
