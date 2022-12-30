package onboarding.problem4.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class WordTest {

    @ParameterizedTest(name = "{0}은 1이상 1000이하의 길이가 아니므로 예외 발생")
    @ValueSource(strings = {""})
    @DisplayName("길이 검증")
    void 길이_검증1(String input) {
        assertThatThrownBy(() -> new Word(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000 이상의 word는 예외 발생")
    @Test
    void 초과_길이_검증() {
        String input = "a".repeat(1001);
        assertThatThrownBy(() -> new Word(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "word가 {0}인 Word의 update 된 값은 {1}")
    @CsvSource({"I love you,R olev blf", "가나다 aAbB, 가나다 zZyY"})
    @DisplayName("문자열 바꾸는 로직 검증")
    void 바꾸는_로직(String input, String result) {
        Word word = new Word(input);
        assertThat(word.getChangedWord()).isEqualTo(result);
    }

}