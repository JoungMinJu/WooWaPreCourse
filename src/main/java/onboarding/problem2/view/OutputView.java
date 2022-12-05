package onboarding.problem2.view;

import onboarding.problem2.model.Cryptogram;

import java.util.Queue;

import static onboarding.problem2.util.Constants.INPUT_GUIDE;
import static onboarding.problem2.util.Constants.RESULT_GUIDE;

public class OutputView {
    StringBuilder sb = new StringBuilder();

    public void printInputGuide(){
        System.out.println(INPUT_GUIDE);
    }

    public void printResult(Cryptogram cryptogram){
        System.out.println(String.format(RESULT_GUIDE, getResultString(cryptogram)));
    }

    private String getResultString(Cryptogram cryptogram){
        clearStringBuilder();
        Queue<Character> cryptoCharacters =
                cryptogram.getCryptoCharacters();
        while(!cryptoCharacters.isEmpty()){
            sb.append(cryptoCharacters.poll());
        }
        return sb.toString();
    }

    private void clearStringBuilder(){
        sb.setLength(0);
    }
}
