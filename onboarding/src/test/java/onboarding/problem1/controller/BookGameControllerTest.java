package onboarding.problem1.controller;

import onboarding.problem1.model.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BookGameControllerTest {
    static Player player1;
    static Player player2;

    BookGameController bookGameController = new BookGameController();

    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of(Arrays.asList(5,6), Arrays.asList(3,4), "일번"),
                Arguments.of(Arrays.asList(1,2), Arrays.asList(1,2), null),
                Arguments.of(Arrays.asList(3,4), Arrays.asList(33,34), "이번")
        );
    }

    @ParameterizedTest(name = "pages {0}인 플레이어1과 pages{1}인 플레이어2가 있을 때 maxScore를 가진 플레이어의 이름은 {2}")
    @MethodSource("getData")
    @DisplayName("최고 점수 가진 선수 구하기 로직")
    void 최고점수선수(List<Integer> input1, List<Integer> input2, String playerName ){
        player1 = new Player("일번", input1);
        player2 = new Player("이번", input2);
        Player maxScorePlayer = bookGameController.getMaxScorePlayer(player1, player2);
        String name;
        if (maxScorePlayer == null){
            name = null;
        }
        else{
            name = maxScorePlayer.getName();
        }
        Assertions.assertThat(name).isEqualTo(playerName);

    }
}