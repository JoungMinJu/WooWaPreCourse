package onboarding.problem7.model;

import onboarding.problem7.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    // 일급컬렉션?
    private List<User> friends;
    private List<User> visitors;
    private int score;

    public User(String name){
        Validator.validateUserName(name);
        this.name = name;
        this.friends = new ArrayList<>();
        this.score = 0;
        this.visitors = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addFriends(User user){
        friends.add(user);
    }

    public void addVisitors(User user){
        visitors.add(user);
    }
}
