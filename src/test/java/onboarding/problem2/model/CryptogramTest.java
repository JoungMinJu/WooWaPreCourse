package onboarding.problem2.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

class CryptogramTest {

    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of("abcd",  new LinkedList<>(Arrays.asList('a','b','c','d'))),
                Arguments.of("bbcde", new LinkedList<>(Arrays.asList('b','b','c','d','e')))
        );
    }

    @ParameterizedTest(name = "{0}은 제한된 길이를 벗어나므로 예외 발생")
    @ValueSource(strings = {""})
    @DisplayName("암호문 길이 조건 판단 로직")
    void 길이_조건(String input){
        Assertions.assertThatThrownBy(() -> new Cryptogram(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000자가 넘어가는 input 입력시 예외 발생")
    @Test
    void 길이_조건_초과(){
        String input = "a".repeat(1001);
        Assertions.assertThatThrownBy(() -> new Cryptogram(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 소문자로만 구성되지 않았으므로 예외 발생")
    @ValueSource(strings = {"Aaaa", "adsf가", "123afjkl"})
    @DisplayName("암호문 타입 검증 로직")
    void 타입_조건(String input){
        Assertions.assertThatThrownBy(() -> new Cryptogram(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}를 활용하여 생성한 Cryptogram의 큐는 {1}")
    @MethodSource("getData")
    @DisplayName("생성자 검증")
    void 생성자(String input, LinkedList<Character> result){
        Cryptogram cryptogram = new Cryptogram(input);
        Assertions.assertThat(cryptogram.getCryptoCharacters())
                .isEqualTo(result);
    }


}