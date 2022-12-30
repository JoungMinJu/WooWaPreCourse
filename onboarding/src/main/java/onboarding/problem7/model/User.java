package onboarding.problem7.model;

import onboarding.problem7.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User>{
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

    public List<User> getVisitors(){
        return visitors;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addScore(int score){
        this.score += score;
    }

    public boolean isMyFriend(User user){
        return friends.stream()
                .map(User::getName)
                .anyMatch(name -> name.equals(user.getName()));
    }

    @Override
    public int compareTo(User user) {
        if(user.score == score){
            return this.name.compareTo(user.name); // 오름차순 정렬
        }
        return user.score - score;
    }

    public int getScore() {
        return score;
    }
}
