package onboarding.problem2.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest(name = "{0}은 제한된 길이를 벗어나므로 예외 발생")
    @ValueSource(strings = {""})
    @DisplayName("암호문 길이 조건 판단 로직")
    void 길이_조건(String input){
        Assertions.assertThatThrownBy(() -> Validator.validateCryptogram(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("1000자가 넘어가는 input 입력시 예외 발생")
    @Test
    void 길이_조건_초과(){
        String input = "a".repeat(1001);
        Assertions.assertThatThrownBy(() -> Validator.validateCryptogram(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 소문자로만 구성되지 않았으므로 예외 발생")
    @ValueSource(strings = {"Aaaa", "adsf가", "123afjkl"})
    @DisplayName("암호문 타입 검증 로직")
    void 타입_조건(String input){
        Assertions.assertThatThrownBy(() -> Validator.validateCryptogram(input))
                .isInstanceOf(IllegalArgumentException.class);
    }





}
