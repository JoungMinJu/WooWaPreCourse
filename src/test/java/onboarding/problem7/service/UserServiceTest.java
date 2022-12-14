package onboarding.problem7.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserServiceTest {
    UserService userService = new UserService();

    @ParameterizedTest(name = "{0}의 이름은 길이가 1미만 30 초과여서 예외 발생")
    @ValueSource(strings = {"", "asdfasdafqeradsfzvcafdghadfgjhadfjhadf"})
    @DisplayName("User 생성시 길이 검증 로직")
    void 길이_검증(String name) {
        assertThatThrownBy(() ->
                userService.getUser(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name =  "{0}은 소문자로만 구성되지 않아서 예외 발생")
    @ValueSource(strings = {"1123aad", "가나다라", "ㄱㅇㅁㄴㄱㅁ", "!*($"})
    @DisplayName("User 생성시 소문자로만 구성됐는지 검증 로직")
    void 타입_검증(String name) {
        assertThatThrownBy(() ->
                        userService.getUser(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}