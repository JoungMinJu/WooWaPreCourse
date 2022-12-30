package onboarding.problem3.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberServiceTest {
    NumberService numberService = new NumberService();

    @ParameterizedTest(name = "{0}에 포함된 3,6,9의 개수는 {1}")
    @CsvSource({"3, 1","1245,0","39378, 3", "1237, 1"})
    @DisplayName("3,6,9 카운팅 로직 검증")
    void 카운팅_로직(int input, int expect){
        int result = numberService.countThreeSixNine(input);
        Assertions.assertThat(result).isEqualTo(expect);
    }

}