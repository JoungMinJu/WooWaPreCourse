package onboarding.problem2.controller;

import onboarding.problem2.model.Cryptogram;
import onboarding.problem2.view.InputView;
import onboarding.problem2.view.OutputView;

import java.util.Queue;
import java.util.Queue;

public class CryptoController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run(){
        outputView.printInputGuide();
        Cryptogram cryptogram = getCryptogram();
        updateResult(cryptogram);

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

    private void updateResult(Cryptogram cryptogram){
        Queue<Character> originCryptoCharacters;
        do{
            originCryptoCharacters = cryptogram.getCryptoCharacters();
            cryptogram.updateCryptogram();
        } while(! cryptogram.isSameSize(originCryptoCharacters));

    }
}
