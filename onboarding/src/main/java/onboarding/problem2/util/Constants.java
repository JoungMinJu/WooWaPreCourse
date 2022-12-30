package onboarding.problem2.util;

public class Constants {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 1000;

    public static final String LENGTH_ERROR = "[ERROR] 암호문의 길이는 %d이상 %d이하 입니다.";
    public static final String TYPE_ERROR = "[ERROR] 암호문은 소문자로만 구성되어야 합니다.";

    public static final String VALIDATE_TYPE_REGEX = "^[a-z]*$";

    public static final String INPUT_GUIDE = "암호문을 입력해주세요";
    public static final String RESULT_GUIDE = "결과 : %s";
}
