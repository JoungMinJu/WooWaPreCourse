package onboarding.problem7.util;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    public static void validateUserName(String name){
        validateUserNameLength(name);
        validateUserNameType(name);
    }

    private static void validateUserNameLength(String name){
        if(name.length() < 1 || name.length() > 30){
            throw new IllegalArgumentException("사용자의 이름은 길이가 1 이상 30 이하여야합니다.");
        }
    }

    private static void validateUserNameType(String name){
        if(!Pattern.matches("^[a-z]*$", name)){
            throw new IllegalArgumentException("사용자의 이름은 소문자로만 구성되어야합니다.");
        }
    }

    public static void validateRelationsSize(int size){
        if (size < 1 || size > 10000){
            throw new IllegalArgumentException("친구 목록의 사이즈는 1 이상 10,000 이하여야합니다.");
        }
    }

    public static void validateRelationFriend(List<String> friends){
        if(friends.size() != 2){
            throw new IllegalArgumentException("친구 관계는 사용자 A와 그와 친구인 B 두 명이 입력되어야 합니다.");
        }
    }
}
