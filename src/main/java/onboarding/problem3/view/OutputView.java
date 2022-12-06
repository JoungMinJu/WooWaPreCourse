package onboarding.problem3.view;

import static onboarding.problem3.util.Constants.INPUT_GUIDE;
import static onboarding.problem3.util.Constants.RESULT_GUIDE;

public class OutputView {

    public void printInputGuide() {
        System.out.println(INPUT_GUIDE);
    }

    public void printResult(int result) {
        System.out.printf(RESULT_GUIDE, result);
    }
}
