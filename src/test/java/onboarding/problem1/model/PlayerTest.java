package onboarding.problem1.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("tmp", Arrays.asList(133, 134), 12),
                Arguments.of("tml", Arrays.asList(119, 120), 11)
        );
    }

    @ParameterizedTest(name = "{1}의 page를 가진 플레이어의 score는 {2}")
    @MethodSource("generateData")
    @DisplayName("각 플레이어의 최고 점수 추출 로직")
    void 점수(String name, List<Integer> pages, int score) {
        Player player = new Player(name, pages);
        Assertions.assertThat(player.getScore()).isEqualTo(score);
    }

}