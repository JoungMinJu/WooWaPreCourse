package onboarding.problem7.repository;

import onboarding.problem7.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void add(User user){
        users.add(user);
    }

    public Optional<User> findByName(String name){
        return users.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }

    public List<User> findAllExceptMeAndMyFriends(User me){
        return users.stream()
                .filter(user -> !user.getName().equals(me.getName()))
                .filter(user -> !me.isMyFriend(user))
                .collect(Collectors.toList());
    }

}
