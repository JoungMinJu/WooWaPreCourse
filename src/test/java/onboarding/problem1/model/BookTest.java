package onboarding.problem1.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(Arrays.asList(35,36), 0, 8),
                Arguments.of(Arrays.asList(123,124), 1, 7),
                Arguments.of(Arrays.asList(233,234), 0, 8),
                Arguments.of(Arrays.asList(335,336), 1, 12)
                );
    }


    static Stream<Arguments> generateSecondData(){
        return Stream.of(
                Arguments.of(Arrays.asList(35,36), 0, 15),
                Arguments.of(Arrays.asList(123,124), 1, 8),
                Arguments.of(Arrays.asList(233,234), 0, 18),
                Arguments.of(Arrays.asList(335,336), 1, 54)
        );
    }



    @ParameterizedTest(name = "{0}의 {1} 번째 숫자의 각자리 합은 {2}")
    @MethodSource("generateData")
    @DisplayName("각 자리 합 구하는 로직")
    void 각자리합(List<Integer> lst, int index, int result){
        Book book = new Book(lst);
        Assertions.assertThat(book.getSumScore(index)).isEqualTo(result);
    }


    @ParameterizedTest(name = "{0}의 {1} 번째 숫자의 각자리 곱은 {2}")
    @MethodSource("generateSecondData")
    @DisplayName("각 자리 곱 구하는 로직")
    void 각자리곱(List<Integer> lst, int index, int result){
        Book book = new Book(lst);
        Assertions.assertThat(book.getMultiScore(index)).isEqualTo(result);
    }

}