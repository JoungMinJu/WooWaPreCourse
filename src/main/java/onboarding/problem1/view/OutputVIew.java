package onboarding.problem1.view;

import onboarding.problem1.model.Player;

import static onboarding.problem1.util.Constants.*;

public class OutputVIew {

    public void printInputGuide(String name){
        System.out.printf(INPUT_GUIDE, name);
    }

    public void printResult(Player maxScorePlayer) {
        System.out.println(getResult(maxScorePlayer));
    }

    private String getResult(Player maxScorePlayer) {
        if(maxScorePlayer == null){
            return TIE_GUIDE;
        }
        return String.format(WINNER_GUIDE, maxScorePlayer.getName());
    }
}
