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
