package onboarding.problem4.view;

public class OutputView {

    public void printInputGuide(){
        System.out.println("word를 입력해주십시오.");
    }

    public void printResult(String result){
        System.out.printf("바뀐 결과 : %s", result);
    }
}
