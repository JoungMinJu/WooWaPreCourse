package onboarding.problem5.view;

import java.util.List;

import static onboarding.problem5.util.Constants.INPUT_GUIDE;
import static onboarding.problem5.util.Constants.RESULT_GUIDE;

public class OutputView {

    public void printInputGuide(){
        System.out.println(INPUT_GUIDE);
    }

    public void printResult(List<Integer> result){
        System.out.printf(RESULT_GUIDE, result.toString());
    }
}
