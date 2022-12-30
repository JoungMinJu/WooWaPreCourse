package onboarding.problem1.model;

import java.util.List;

public class Player {
    private String name;
    private Book book;
    private int score;

    public Player(String name, List<Integer> pages){
        this.name = name;
        this.book = new Book(pages);
        this.score = 0;
    }

    private void updateScore(){
        int maxSumScore = book.getMaxSumScore();
        int maxMultiScore = book.getMaxMultiScore();
        score = Math.max(maxSumScore, maxMultiScore);
    }

    public int getScore(){
        updateScore();
        return score;
    }

    public String getName(){
        return name;
    }
}
