package onboarding.problem3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    InputView inputView = new InputView();

    private void setSetIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @ParameterizedTest(name = "{0}을 입력하면 {1}을 반환")
    @CsvSource({"123,123", "2345,2345"})
    @DisplayName("사용자 숫자 입력 로직 검증")
    void 사용자_입력_검증(String input, int result){
        setSetIn(input);
        int userNumber = inputView.getUserNumber();
        assertThat(userNumber).isEqualTo(result);
    }


    @ParameterizedTest(name = "{0}을 입력하면 숫자가 아니므로 예외 발생")
    @ValueSource(strings = {"가", "ajdklf"})
    @DisplayName("사용자 숫자 입력 로직 예외 검증")
    void 사용자_입력_예외_검증(String input){
        setSetIn(input);
        assertThatThrownBy(() -> inputView.getUserNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}