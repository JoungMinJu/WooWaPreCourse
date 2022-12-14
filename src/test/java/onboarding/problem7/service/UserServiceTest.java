package onboarding.problem7.service;

import onboarding.problem7.model.User;
import onboarding.problem7.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserServiceTest {
    static UserService userService = new UserService();

    @BeforeAll
    static void before(){
        userService.createAndGetUser("a");
        userService.createAndGetUser("b");
    }

    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of(List.of("a", "b"), List.of("a", "b"))
        );
    }

    @ParameterizedTest(name = "{0}의 이름은 길이가 1미만 30 초과여서 예외 발생")
    @ValueSource(strings = {"", "asdfasdafqeradsfzvcafdghadfgjhadfjhadf"})
    @DisplayName("User 생성시 길이 검증 로직")
    void 길이_검증(String name) {
        assertThatThrownBy(() ->
                userService.createAndGetUser(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name =  "{0}은 소문자로만 구성되지 않아서 예외 발생")
    @ValueSource(strings = {"1123aad", "가나다라", "ㄱㅇㅁㄴㄱㅁ", "!*($"})
    @DisplayName("User 생성시 소문자로만 구성됐는지 검증 로직")
    void 타입_검증(String name) {
        assertThatThrownBy(() ->
                        userService.createAndGetUser(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}의 이름들을 User로 변환한 각 결과의 getName 리스트 결과는 {1}")
    @MethodSource("getData")
    @DisplayName("findAllByName 로직")
    void findAllByName(List<String> input, List<String> expected){
        List<User> allByName = userService.findAllByName(input);
        List<String> result = allByName.stream()
                .map(user -> user.getName())
                .collect(Collectors.toList());
        assertThat(result).isEqualTo(expected);
    }


}