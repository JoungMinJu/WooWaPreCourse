package onboarding.problem7.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of(List.of("a", "b", "c")),
                Arguments.of(List.of("a"))
        );
    }

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

    @ParameterizedTest(name = "{0}은 1이상 10,000이하가 아니어서 에외 발생")
    @ValueSource(ints = {0, 10001, 100000})
    @DisplayName("친구 목록 사이즈 검증")
    void 목록_사이즈_검증(int size){
        assertThatThrownBy( () ->
                Validator.validateRelationsSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 두 개의 사람이 주어지지 않아서 예외 발생")
    @MethodSource("getData")
    @DisplayName("관계 요소 개수 검증")
    void 관계_요소_개수(List<String> friends){
        assertThatThrownBy(() ->
                Validator.validateRelationFriend(friends))
                .isInstanceOf(IllegalArgumentException.class);
    }
}