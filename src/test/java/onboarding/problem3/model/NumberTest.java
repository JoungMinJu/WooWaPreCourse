package onboarding.problem3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {


    @ParameterizedTest(name = "{0}을 입력하면  길이 제한 조건에 따라 예외 발생")
    @ValueSource(ints = {0, 1000000})
    @DisplayName("사용자 숫자 입력 로직 예외 검증")
    void 사용자_입력_검증(int input){
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}