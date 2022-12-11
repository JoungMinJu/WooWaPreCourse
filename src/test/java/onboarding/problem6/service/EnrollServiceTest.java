package onboarding.problem6.service;

import onboarding.problem6.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EnrollServiceTest {
    EnrollService enrollService = new EnrollService();

    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of("alswn@email.com 정민주,alswjd@email.com 정민정",
                        List.of(new Person("alswn@email.com","정민주"), new Person("alswjd@email.com", "정민정")))
        );
    }

    static Stream<Arguments> getSecondData(){
        return Stream.of(
                Arguments.of(List.of(new Person("alswn@email.com", "정민주"),
                                    new Person("alswjd@email.com","정민정"),
                                    new Person( "a@email.com","가나다"),
                                    new Person("b@email.com", "마나다"),
                                    new Person("c@email.com", "가나민주"),
                                    new Person("d@email.com", "라마나다"),
                                    new Person("f@email.com", "바차카타")),
                            List.of("alswn@email.com","alswjd@email.com","a@email.com","b@email.com",
                                    "c@email.com","d@email.com"))
        );
    }

    @ParameterizedTest(name = "{0}는 사람 숫자가 1명 이상 10,000명 이하가 아니어서 예외")
    @ValueSource(strings = {""})
    @DisplayName("사람 숫자 검증 로직")
    void 사람_숫자_검증(String input){
        assertThatThrownBy(() -> enrollService.getPersons(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 이메일, 닉네임으로 파라미터가 두 개 주어지지 않아서 예외 발생")
    @ValueSource(strings = {"alswn@email.com 정민주 24", "alswjd@email.com"})
    @DisplayName("이메일, 닉네임 파라미터 개수 검증 로직")
    void 파라미터_개수(String input){
        assertThatThrownBy(() -> enrollService.getPersons(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 이메일 길이가 11 이상 20미만이 아니어서 예외 발생")
    @ValueSource(strings = {"@email.com 정민주", "aaaaaaaaaaaaaaalswjd@email.com 정민정"})
    @DisplayName("이메일 길이 검증")
    void 이메일_검증_로직(String input){
        assertThatThrownBy(() -> enrollService.getPersons(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 이메일 형식을 갖추지 않아서 예외 발생")
    @ValueSource(strings = {"alswndsfsjklafd 정민주"})
    @DisplayName("이메일 형식 검증")
    void 이메일_형식_검증(String input){
        assertThatThrownBy(() -> enrollService.getPersons(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 email.com 도메인이 아니어서 예외 발생")
    @ValueSource(strings = {"alswn9938@gmail.com 정민주"})
    @DisplayName("이메일 도메인 검증")
    void 이메일_도메인_검증(String input){
        assertThatThrownBy(() -> enrollService.getPersons(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 닉네임이 한글이 아니어서 예외 발생")
    @ValueSource(strings = {"alswn9938@gmail.com ajl", "alswjd@gmail.com 가132"})
    @DisplayName("닉네임 형식 검증")
    void 닉네임_형식_검증(String input){
        assertThatThrownBy(() -> enrollService.getPersons(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 닉네임 길이가 1자 이상 20미만이 아니어서 예외발생")
    @ValueSource(strings = {"alswn9938@gmail.com 아아아아아아아아아아아아아아아아아아아아아아"})
    @DisplayName("닉네임 길이 검증")
    void 닉네임_길이_검증(String input){
        assertThatThrownBy(() -> enrollService.getPersons(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}의 input은 {1}을 반환")
    @MethodSource("getData")
    @DisplayName("사람 리스트 get 로직 검증")
    void 성공_로직(String input, List<Person> expected){
        List<Person> result = enrollService.getPersons(input);
        List<String> resultPersonString = new ArrayList<>();
        List<String> expectedPersonString = new ArrayList<>();
        for (Person person : result) {
            resultPersonString.add(person.toString());
        }
        for (Person person : expected) {
            expectedPersonString.add(person.toString());
        }
        assertThat(resultPersonString).isEqualTo(expectedPersonString);
    }

    @ParameterizedTest(name = "{0} 리스트의 중복 닉네임 이메일 리스트는 {1}")
    @MethodSource("getSecondData")
    @DisplayName("중복 닉네임 이메일 리스트 get 로직 검증")
    void 중복_닉네임_이메일(List<Person> persons, List<String> expected){
        List<String> result = enrollService.getDuplicatedNickNamePersonEmails(persons);
        assertThat(result).containsAll(expected);
    }

}