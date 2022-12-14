package onboarding.problem7.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    static User user;

    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of(new User("a"), true),
                Arguments.of(new User("b"), true),
                Arguments.of(new User("c"), false)
        );
    }

    @BeforeAll
    static void before(){
        user = new User("me");
        user.addFriends(new User("a"));
        user.addFriends(new User("b"));
    }

    @ParameterizedTest(name = "{0}의 유저는 user의 친구인지에 대한 결과는 {1}")
    @MethodSource("getData")
    @DisplayName("isMyFriend 로직 검증")
    void isMyFriend(User friend, boolean expected){
        boolean result = user.isMyFriend(friend);
        Assertions.assertThat(result)
                .isEqualTo(expected);
    }

}