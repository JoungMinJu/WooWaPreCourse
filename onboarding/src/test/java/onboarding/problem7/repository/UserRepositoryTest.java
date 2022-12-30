package onboarding.problem7.repository;

import onboarding.problem7.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest {

    static UserRepository userRepository = new UserRepository();

    @BeforeAll
    static void beforeAll(){
        userRepository.add(new User("a"));
        userRepository.add(new User("b"));
    }


    @ParameterizedTest(name = "{0}의 이름을 가진 유저가 없으면 Optional.isEmpty() == true")
    @ValueSource(strings = {"c", "da"})
    @DisplayName("findByName 로직 - 없을 경우")
    void findByName_못찾음(String name){
        Optional<User> result = userRepository.findByName(name);
        assertThat(result.isEmpty())
                .isTrue();
    }

    @ParameterizedTest(name= "{0}의 이름을 가진 유저를 찾아내고 getName을 하면 {0}이 출력")
    @ValueSource(strings = {"a", "b"})
    @DisplayName("findByName 로직 - 있을 경우")
    void findByName_찾음(String name){
        Optional<User> result = userRepository.findByName(name);
        assertThat(result.get().getName())
                .isEqualTo(name);
    }


}