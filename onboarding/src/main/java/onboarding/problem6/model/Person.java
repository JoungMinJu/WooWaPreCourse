package onboarding.problem6.model;

public class Person {
    String email;
    String nickname;

    public Person(String email, String nickname){
        this.email = email;
        this.nickname = nickname;
    }

    public String getNickname(){
        return nickname;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
