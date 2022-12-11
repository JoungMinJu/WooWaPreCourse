package onboarding.problem6.util;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    public static void validateNumberOfPerson(List<String> input){
        if(input.size() < 1 || input.size() > 10000){
            throw new IllegalArgumentException("[ERROR] 크루는 1명 이상 10,000명 이하여야합니다.");
        }
    }

    public static void validateNumberOfPersonParam(List<String> input){
        if(input.size() != 2){
            throw new IllegalArgumentException("[ERROR] 이메일과 이름 두 가지가 입력되어야 합니다.");
        }
    }

    public static void validateEmail(String input){
        validateEmailLength(input);
        validateEmailForm(input);
    }

    private static void validateEmailForm(String input){
        String[] split = input.split("@");
        if( split.length != 2){
            throw new IllegalArgumentException("[ERROR] 이메일은 이메일 형식으로 입력되어야 합니다.");
        }
        if(!split[1].equals("email.com")){
            throw new IllegalArgumentException("[ERROR] 이메일은 email.com 도메인만 허용합니다.");
        }
    }

    private static void validateEmailLength(String input){
        if(input.length() < 11 || input.length() >= 20){
            throw new IllegalArgumentException("[ERROR] 이메일은 11자 이상 20자 미만이어야합니다.");
        }
    }

    public static void validateNickname(String input){
        validateNickNameLength(input);
        validateNicknameForm(input);
    }

    private static void validateNicknameForm(String input){
        if(!Pattern.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*", input)){
            throw new IllegalArgumentException("[ERROR] 닉네임은 한글이어야합니다.");
        }
    }

    private static void validateNickNameLength(String input){
        if(input.length() < 1 || input.length() >= 20){
            throw new IllegalArgumentException("[ERROR] 닉네임은 1자 이상 20자 미만이어야합니다.");
        }
    }

}
