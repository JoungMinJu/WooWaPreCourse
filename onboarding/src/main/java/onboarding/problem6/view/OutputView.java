package onboarding.problem6.view;

import java.util.Collections;
import java.util.List;

import static onboarding.problem6.util.Constants.INPUT_GUIDE;

public class OutputView {
    public void printInputGuide(){
        System.out.println(INPUT_GUIDE);
    }

    public void printResult(List<String> emails){
        Collections.sort(emails);
        System.out.println(emails.toString());
    }

    public void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
