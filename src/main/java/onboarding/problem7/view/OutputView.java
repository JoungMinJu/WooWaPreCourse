package onboarding.problem7.view;

import onboarding.problem7.model.User;

import java.util.List;
import java.util.stream.Collectors;

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

    public void printVisitorsInputGuide(){
        System.out.println("해당 User 방문자 목록 입력해주세요(공백으로 구분) : ");
    }

    public void printResult(List<User> result){
        List<String> resultNames = getResultNames(result);
        System.out.println("결과 : " + resultNames.toString());
    }

    private List<String> getResultNames(List<User> result){
        return result.stream()
                .map(User::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
