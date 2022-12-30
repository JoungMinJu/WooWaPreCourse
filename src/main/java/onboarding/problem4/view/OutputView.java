package onboarding.problem4.view;

import static onboarding.problem4.util.Constants.INPUT_GUIDE;
import static onboarding.problem4.util.Constants.OUTPUT_GUIDE;

public class OutputView {

    public void printInputGuide(){
        System.out.println(INPUT_GUIDE);
    }

    public void printResult(String result){
        System.out.printf(OUTPUT_GUIDE, result);
    }
}
