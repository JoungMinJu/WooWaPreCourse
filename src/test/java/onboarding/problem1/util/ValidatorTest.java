package onboarding.problem1.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidatorTest {


     static Stream<Arguments> generateFirstData(){
        return Stream.of(
                Arguments.of(Arrays.asList("1","2","3","4")),
                Arguments.of(Arrays.asList("1"))
        );
    }

    static Stream<Arguments> generateSecondData(){
        return Stream.of(
                Arguments.of(Arrays.asList("a","2")),
                Arguments.of(Arrays.asList("ㅁ","1")),
                Arguments.of(Arrays.asList("12", "a"))
        );
    }


    @ParameterizedTest(name = "{0}은 범위를 벗어난 길이로 예외 발생")
    @MethodSource("generateFirstData")
    @DisplayName("길이 범위 벗어난 경우")
    void validateBridgeLength(List<String> input) {
        Assertions.assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "{0}은 숫자가 아닌 값 포함으로 예외 발생")
    @MethodSource("generateSecondData")
    @DisplayName("숫자 길이 벗어난 경우")
    void validateBridgeType(List<String> input) {
        Assertions.assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}