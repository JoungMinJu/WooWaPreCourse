package onboarding.problem1.view;

import onboarding.problem1.model.Player;

public class OutputVIew {

    public void printInputGuide(String name){
        System.out.printf("%s의 왼쪽 페이지 번호, 오른쪽 페이지 번호를 공백으로 구분하여 입력해주세요", name);
    }

    public void printResult(Player maxScorePlayer) {
        System.out.println(getResult(maxScorePlayer));
    }

    private String getResult(Player maxScorePlayer) {
        if(maxScorePlayer == null){
            return "무승부입니다.";
        }
        return String.format("%s님이 이겼습니다.", maxScorePlayer.getName());
    }
}
