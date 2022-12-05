package onboarding.problem2.controller;

import onboarding.problem2.model.Cryptogram;
import onboarding.problem2.view.InputView;
import onboarding.problem2.view.OutputView;

public class CryptoController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run(){
        outputView.printInputGuide();
        Cryptogram cryptogram = getCryptogram();
        // return 받기
    }

    private Cryptogram getCryptogram(){
        while(true){
            try {
                String userInput = inputView.getUserInput();
                return new Cryptogram(userInput);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
