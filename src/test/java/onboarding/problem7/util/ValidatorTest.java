package onboarding.problem7.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest(name = "{0}은 길이가 1 미만 30 초과여서 예외 발생")
    @ValueSource(strings = {"", "asdfasdafqeradsfzvcafdghadfgjhadfjhadf"})
    @DisplayName("닉네임 길이 검증 로직")
    void 닉네임_길이_검증(String name){
        assertThatThrownBy(() ->
                Validator.validateUserName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 소문자로만 구성되지 않아서 예외 발생")
    @ValueSource(strings = {"1123aad", "가나다라", "ㄱㅇㅁㄴㄱㅁ", "!*($"})
    @DisplayName("닉네임 소문자로만 구성됐는지 검증 로직")
    void 닉네임_타입_검증(String name){
        assertThatThrownBy(() ->
                Validator.validateUserName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}