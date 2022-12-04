package onboarding.problem1.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of("1 2", Arrays.asList(1,2)),
                Arguments.of("2 3", Arrays.asList(2,3))
        );
    }

    private void setSetIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @ParameterizedTest(name = "길이가 2가 아닌 {0}가 입력되면 예외 발생")
    @ValueSource(strings = {"1 2 3", "1"})
    void 길이_예외(String input){
        setSetIn(input);
        Assertions.assertThatThrownBy(() -> inputView.getUserInputPages()).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "숫자가 아닌 {0}가 입력되면 예외 발생")
    @ValueSource(strings = {"r ㅁ", "2 아"})
    void 타입예외(String input){
        setSetIn(input);
        Assertions.assertThatThrownBy(() -> inputView.getUserInputPages()).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "{0}의 결과는 {1}")
    @MethodSource("generateData")
    void 정상_입력(String input, List<Integer> lst){
        setSetIn(input);
        List<Integer> userInputPages = inputView.getUserInputPages();
        Assertions.assertThat(userInputPages).isEqualTo(lst);
    }


}