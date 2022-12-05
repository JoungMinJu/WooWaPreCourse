package onboarding.problem2.view;

import onboarding.problem2.model.Cryptogram;

import java.util.Queue;

public class OutputView {
    StringBuilder sb = new StringBuilder();

    public void printInputGuide(){
        System.out.println("암호문을 입력해주세요");
    }

    public void printResult(Cryptogram cryptogram){
        System.out.println(String.format("결과 : %s", getResultString(cryptogram)));
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
