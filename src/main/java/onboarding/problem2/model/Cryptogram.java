package onboarding.problem2.model;

import onboarding.problem2.util.Validator;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;

public class Cryptogram {
    Queue<Character> cryptoCharacters;

    public Cryptogram(String cryptogram) {
        Validator.validateCryptogram(cryptogram);
        cryptoCharacters = new LinkedList<>();
        for (int index = 0; index < cryptogram.length(); index++) {
            cryptoCharacters.add(cryptogram.charAt(index));
        }
    }

    public Queue<Character> getCryptoCharacters() {
        return new LinkedList<>(cryptoCharacters);
    }

    public void updateCryptogram() {
        Queue<Character> tmp = new LinkedList<>();
        Character zero = ' ';
        while(!cryptoCharacters.isEmpty()){
            Character first = cryptoCharacters.poll();
            Character second = cryptoCharacters.peek();
            if (first != zero && first != second){
                tmp.add(first);
            }
            zero = first;
        }
        this.cryptoCharacters = tmp;
    }

    public boolean isSameSize(Queue<Character> originCryptoCharacters){
        return cryptoCharacters.size() == originCryptoCharacters.size();
    }

}
