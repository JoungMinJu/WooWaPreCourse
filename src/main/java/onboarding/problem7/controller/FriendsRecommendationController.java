package onboarding.problem7.controller;

import onboarding.problem7.model.User;
import onboarding.problem7.service.UserService;
import onboarding.problem7.view.InputView;
import onboarding.problem7.view.OutputView;

public class FriendsRecommendationController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    UserService userService = new UserService();

    public void run() {
        User user = getUser();
    }

    private User getUser() {
        String name;
        outputView.printInputUserGuide();
        while (true) {
            try {
                name = inputView.getUserInput();
                return userService.getUser(name);
            } catch (IllegalArgumentException e) {
                outputView.printResult(e.getMessage());
            }
        }
    }
}
