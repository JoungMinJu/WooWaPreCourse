package onboarding.problem7.service;

import onboarding.problem7.model.User;
import onboarding.problem7.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

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

    public void updateVisitorScore(User visitorDto){
        User visitor = createAndGetUser(visitorDto.getName());
        visitor.addScore(1);
    }

}
