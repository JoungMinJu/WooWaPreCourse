package onboarding.problem5.view;

import java.util.List;

public class OutputView {

    public void printInputGuide(){
        System.out.println("금액을 입력해주세요");
    }

    public void printResult(List<Integer> result){
        System.out.printf("결과 : %s", result.toString());
    }
}
