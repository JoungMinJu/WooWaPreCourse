package onboarding.problem1.model;

import java.util.List;

public class Player {
    private String name;
    private Book book;

    public Player(String name, List<Integer> pages){
        this.name = name;
        this.book = new Book(pages);
    }

}
