package onboarding.problem7.service;

import onboarding.problem7.model.User;
import onboarding.problem7.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User createAndGetUser(String name){
        User user = new User(name);
        userRepository.add(user);
        return user;
    }


    public List<User> findAllByName(List<String> names){
        List<User> users = new ArrayList<>();
        for (String name : names) {
            if(userRepository.findByName(name).isEmpty()){
                userRepository.add(new User(name));
            }
            User user = userRepository.findByName(name).get();
            users.add(user);
        }
        return users;
    }

    public void updateUsersRelation(List<User> users){
        User userOne = users.get(0);
        User userTwo = users.get(1);

        userOne.addFriends(userTwo);
        userTwo.addFriends(userOne);
    }

    public void updateVisitorScore(User visitor){
        visitor.addScore(1);
    }

    public void findTargetUsersAndUpdateMutualScore(User me){
        List<User> allExceptMeAndMyFriends
                = userRepository.findAllExceptMeAndMyFriends(me);
        for (User user : allExceptMeAndMyFriends) {
            updateMutualScore(me, user);
        }
    }

    private void updateMutualScore(User me, User targetUser){
        List<User> friends = targetUser.getFriends();
        for (User friend : friends) {
            if(me.isMyFriend(friend)){
                targetUser.addScore(10);
            }
        }
    }

    public List<User> getResult(User me){
        List<User> findUsers = userRepository.findAllExceptMe(me);
        Collections.sort(findUsers);
        return findUsers.stream()
                .filter(user -> !me.isMyFriend(user))
                .filter(user -> user.getScore() > 0)
                .limit(5)
                .collect(Collectors.toList());
    }

}
