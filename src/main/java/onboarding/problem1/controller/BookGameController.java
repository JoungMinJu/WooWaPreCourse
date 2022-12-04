package onboarding.problem1.controller;

import camp.nextstep.edu.missionutils.Console;
import onboarding.problem1.model.Player;
import onboarding.problem1.view.InputView;
import onboarding.problem1.view.OutputVIew;

import java.util.List;

public class BookGameController {
    OutputVIew outputVIew = new OutputVIew();
    InputView inputView = new InputView();

    public void run(){
        Player pobi = createPlayer("포비");
        Player crong = createPlayer("크롱");
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
