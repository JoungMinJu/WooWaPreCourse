package onboarding.problem5.service;

import onboarding.problem5.model.Change;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ChangeServiceTest {

    ChangeService changeService = new ChangeService();

    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of(new Change(50237), List.of(1, 0, 0, 0, 0, 2, 0, 3, 7)),
                Arguments.of(new Change(15000), List.of(0, 1, 1, 0, 0, 0, 0, 0, 0))
        );
    }

    @ParameterizedTest(name = "{0}의 거스름돈 결과값은 {1}")
    @MethodSource("getData")
    @DisplayName("거스름돈 리스트 return 로직 검증")
    void 거스름돈(Change change, List<Integer> expected){
        List<Integer> result = changeService.getResult(change);
        assertThat(result).isEqualTo(expected);
    }

}