package onboarding.problem7.service;

import onboarding.problem7.model.User;

public class UserService {

    public User getUser(String name){
        return new User(name);
    }

}
