package onboarding.problem4.controller;

import onboarding.problem4.model.Word;
import onboarding.problem4.view.InputView;
import onboarding.problem4.view.OutputView;

public class WordGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run(){
        outputView.printInputGuide();
        Word userWord = getUserWord();
    }


    private Word getUserWord(){
        while(true){
            try{
                String userWord = inputView.getUserWord();
                return new Word(userWord);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
