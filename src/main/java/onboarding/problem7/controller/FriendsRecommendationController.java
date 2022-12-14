package onboarding.problem7.controller;

import onboarding.problem7.model.User;
import onboarding.problem7.service.UserService;
import onboarding.problem7.util.Validator;
import onboarding.problem7.view.InputView;
import onboarding.problem7.view.OutputView;

import java.util.List;

public class FriendsRecommendationController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    UserService userService = new UserService();

    public void run() {
        User user = getUser();
        int relationsSize = getRelationsSize();
        getRelationsAndUpdateUserRelation(relationsSize);
        getAndUpdateVisitors(user);
        updateUsersScore(user);
    }

    private User getUser() {
        String name;
        outputView.printInputUserGuide();
        while (true) {
            try {
                name = inputView.getUserInput();
                return userService.createAndGetUser(name);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int getRelationsSize() {
        outputView.printInputRelationsSizeGuide();
        while (true) {
            try {
                int size = inputView.getIntUserInput();
                Validator.validateRelationsSize(size);
                return size;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void getRelationsAndUpdateUserRelation(int relationsSize) {
        for (int count = 1; count <= relationsSize; count++) {
            List<User> usersInRelation = getUsersInRelation();
            userService.updateUsersRelation(usersInRelation);
        }
    }

    private List<User> getUsersInRelation() {
        outputView.printRelationInputGuide();
        while (true) {
            try {
                List<String> names = inputView.getRelationNames();
                Validator.validateRelationFriend(names);
                return userService.findAllByName(names);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void getAndUpdateVisitors(User user){
        List<User> visitors = getVisitors();
        for (User visitor : visitors) {
            user.addVisitors(visitor);
        }
    }

    private List<User> getVisitors(){
        outputView.printVisitorsInputGuide();
        while(true){
            try{
                List<String> visitors = inputView.getVisitors();
                return userService.findAllByName(visitors);
            } catch(IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }

    private void updateUsersScore(User me){
        // 전체 User 가져오기
        updateScoreOfMutualFriends(me);
        updateScoreOfVisitorsFriends(me);
    }

    private void updateScoreOfMutualFriends(User me){
        userService.findTargetUsersAndUpdateMutualScore(me);
    }

    private void updateScoreOfVisitorsFriends(User me){
        List<User> visitors = me.getVisitors();
        for (User visitor : visitors) {
            userService.updateVisitorScore(visitor);
        }
    }

}
