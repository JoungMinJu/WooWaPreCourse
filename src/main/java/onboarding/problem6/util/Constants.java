package onboarding.problem6.util;

public class Constants {

    public final static String PERSON_SEPARATOR = ",";
    public final static String PARAMETER_SEPARATOR = " ";
    public final static String EMAIL_SEPARATOR = "@";
    public final static String VALID_EMAIL_DOMAIN = "email.com";
    public final static int EMAIL_INDEX = 0;
    public final static int NICKNAME_INDEX = 1;
    public final static int DOMAIN_INDEX = 1;
    public final static int MIN_NUMBER_OF_PERSON = 1;
    public final static int MAX_NUMBER_OF_PERSON = 10000;
    public final static int MIN_LENGTH_OF_EMAIL = 11;
    public final static int MAX_LENGTH_OF_EMAIL = 20;
    public final static int MIN_LENGTH_OF_NICKNAME = 1;
    public final static int MAX_LENGTH_OF_NICKNAME = 20;

    public final static int TWO_CHARACTER_REFERENCE_VALUE = 2;

    public final static int DUPLICATED_REFERENCE_VALUE = 2;

    public final static String KOREAN_REGEX = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";

    public final static String PERSON_NUMBER_ERROR =
             String.format("[ERROR] 크루는 %d명 이상 %d명 이하여야합니다.",MIN_NUMBER_OF_PERSON, MAX_NUMBER_OF_PERSON);
    public final static String PARAMETER_NUMBER_ERROR = "[ERROR] 이메일과 이름 두 가지가 입력되어야 합니다.";
    public final static String EMAIL_FORM_ERROR = "[ERROR] 이메일은 이메일 형식으로 입력되어야 합니다.";
    public final static String EMAIL_DOMAIN_ERROR =
            String.format("[ERROR] 이메일은 %s 도메인만 허용합니다.", VALID_EMAIL_DOMAIN);
    public final static String EMAIL_LENGTH_ERROR =
            String.format("[ERROR] 이메일은 %d자 이상 %d자 미만이어야합니다.",MIN_LENGTH_OF_EMAIL, MAX_LENGTH_OF_EMAIL);
    public final static String NICKNAME_TYPE_ERROR = "[ERROR] 닉네임은 한글이어야합니다.";
    public final static String NICKNAME_LENGTH_ERROR =
            String.format("[ERROR] 닉네임은 %d자 이상 %d자 미만이어야합니다.",MIN_LENGTH_OF_NICKNAME, MAX_LENGTH_OF_NICKNAME);

    public final static String INPUT_GUIDE = "이메일과 닉네임을 입력해주세요. (이메일-닉네임 구분자 :  (공백) / 사람-사람 구분자 : ,(쉼표)";
}
