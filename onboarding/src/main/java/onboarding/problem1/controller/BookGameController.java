package onboarding.problem1.controller;

import camp.nextstep.edu.missionutils.Console;
import onboarding.problem1.model.Player;
import onboarding.problem1.view.InputView;
import onboarding.problem1.view.OutputVIew;

import java.util.List;

import static onboarding.problem1.util.Constants.FIRST_PLAYER_NAME;
import static onboarding.problem1.util.Constants.SECOND_PLAYER_NAME;

public class BookGameController {
    OutputVIew outputVIew = new OutputVIew();
    InputView inputView = new InputView();

    public void run(){
        Player pobi = createPlayer(FIRST_PLAYER_NAME);
        Player crong = createPlayer(SECOND_PLAYER_NAME);
        Player maxScorePlayer = getMaxScorePlayer(pobi, crong);
        outputVIew.printResult(maxScorePlayer);
    }

    public Player getMaxScorePlayer(Player player1, Player player2){
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();
        if(player1Score > player2Score){
            return player1;
        }
        if(player2Score > player1Score){
            return player2;
        }
        return null;
    }

    private Player createPlayer(String name){
        while(true){
            try{
                outputVIew.printInputGuide(name);
                List<Integer> pages = getUserInputPages();
                return new Player(name, pages);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getUserInputPages() {
        while(true){
            try{
                return inputView.getUserInputPages();
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
