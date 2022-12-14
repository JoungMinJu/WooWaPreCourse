package onboarding.problem7.model;

import onboarding.problem7.util.Validator;

public class User {
    String name;

    public User(String name){
        Validator.validateUserName(name);
        this.name = name;
    }
}
