package onboarding.problem6.view;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public void printInputGuide(){
        System.out.println("이메일과 닉네임을 입력해주세요. (이메일-닉네임 구분자 :  (공백) / 사람-사람 구분자 : ,(쉼표)");
    }

    public void printResult(List<String> emails){
        Collections.sort(emails);
        System.out.println(emails.toString());
    }

    public void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
