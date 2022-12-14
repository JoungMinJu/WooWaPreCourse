package onboarding.problem7.view;

public class OutputView {

    public void printError(String errorMessage){
        System.out.println("[ERROR]" + errorMessage);
    }

    public void printInputUserGuide(){
        System.out.println("사용자 아이디를 입력해주세요 : ");
    }

    public void printInputRelationsSizeGuide(){
        System.out.println("친구 목록의 사이즈를 입력해주세요 : ");
    }

    public void printRelationInputGuide(){
        System.out.println("서로 아는 친구를 입력해주세요(공백으로 구분) : ");
    }
}
