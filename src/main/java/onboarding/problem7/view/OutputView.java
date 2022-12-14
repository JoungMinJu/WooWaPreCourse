package onboarding.problem7.view;

public class OutputView {
    public void printInputUserGuide(){
        System.out.println("사용자 아이디를 입력해주세요 : ");
    }

    public void printResult(String errorMessage){
        System.out.println("[ERROR]" + errorMessage);
    }
}
