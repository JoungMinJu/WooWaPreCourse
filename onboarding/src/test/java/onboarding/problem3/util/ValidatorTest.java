package onboarding.problem3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @ParameterizedTest(name = "{0}은 숫자가 아니어서 예외 발생")
    @ValueSource(strings = {"가나다라", "12가", "142a", "!234"})
    @DisplayName("입력 타입 검증 로직")
    void 타입_검증(String input){
        assertThatThrownBy(() -> Validator.validateIsNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 범위에 벗어난 숫자여서 예외 발생")
    @ValueSource(ints = {0, 100000, 1001001101})
    @DisplayName("입력 숫자 범위 검증 로직")
    void 범위_검증(int input){
        assertThatThrownBy(() -> Validator.validateRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}