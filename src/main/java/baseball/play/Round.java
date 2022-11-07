package baseball.play;

import baseball.input.UserInput;
import baseball.output.Guide;
import baseball.output.Result;

import java.util.*;

public class Round {
    UserInput userInput = new UserInput();

    public void run(List<Integer> computerNumberList) {
        boolean isCorrect;
        Result result = new Result();

        do {
            List<Integer> userNumberList = userInput.getNumberList();
            result.updateResult(userNumberList, computerNumberList);
            result.printResult();
            isCorrect = result.getIsCorrect();
        } while (!isCorrect);

        Guide.printEndingGuide();
    }
}
