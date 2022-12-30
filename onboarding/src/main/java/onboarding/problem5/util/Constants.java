package onboarding.problem5.util;

import java.util.List;

public class Constants {

    public static final List<Integer> INIT_UNITS = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static int INIT_INDEX = 0;

    public static String NUMERIC_ERROR = "[ERROR] 금액은 숫자여야합니다.";
    public static String RANGE_ERROR = "[ERROR] 금액은 1원 이상 1,000,000원 이하여야합니다.";

    public static String INPUT_GUIDE = "금액을 입력해주세요";
    public static String RESULT_GUIDE = "결과 : %s";
}
