package onboarding.problem5.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest(name = "{0}은 숫자가 아니어서 예외가 발생합니다.")
    @ValueSource(strings = {"가나다","abjld", "a", "13*91"})
    @DisplayName("숫자가 아닌 값 검증 로직")
    void 숫자_검증_로직(String input){
        Assertions.assertThatThrownBy(() -> Validator.validateIsNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 범위를 벗어나서 예외 발생")
    @ValueSource(ints = {0, 10000000, 1000001})
    @DisplayName("숫자 범위 검증 로직")
    void 범위_검증_로직(int input){
        Assertions.assertThatThrownBy(() -> Validator.validateRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}