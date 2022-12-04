package onboarding.problem1.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


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

    static Stream<Arguments> generateThirdData(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,3)),
                Arguments.of(Arrays.asList(2,5))
        );
    }

    static Stream<Arguments> generateFourth(){
        return Stream.of(
                Arguments.of(Arrays.asList(4,5)),
                Arguments.of(Arrays.asList(6,7))
        );
    }


    @ParameterizedTest(name = "{0}은 범위를 벗어난 길이로 예외 발생")
    @MethodSource("generateFirstData")
    @DisplayName("길이 범위 벗어난 경우")
    void validateBridgeLength(List<String> input) {
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "{0}은 숫자가 아닌 값 포함으로 예외 발생")
    @MethodSource("generateSecondData")
    @DisplayName("숫자 길이 벗어난 경우")
    void validateBridgeType(List<String> input) {
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "{0}은 연속된 숫자가 아니므로 예외 발생")
    @MethodSource("generateThirdData")
    @DisplayName("연속된 숫자가 아닌 경우")
    void validateContinuous(List<Integer> input){
         assertThatThrownBy(() -> Validator.validatePages(input))
                 .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 왼쪽 페이지가 홀수가 아니고 오른쪽 페이지가 짝수가 아니므로 예외 발생")
    @MethodSource("generateFourth")
    @DisplayName("왼쪽 페이지가 홀수가 아니고 오른쪽 페이지가 짝수가 아닌 경우 경우")
    void validateOdd(List<Integer> input){
        assertThatThrownBy(() -> Validator.validatePages(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}