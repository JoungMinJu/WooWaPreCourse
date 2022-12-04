package onboarding.problem1.model;

import onboarding.problem1.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final List<Integer> pages;

    public Book(List<Integer> pages) {
        Validator.validatePages(pages);
        this.pages = new ArrayList<>(pages);
    }

    public int getSumScore(int index) {
        int tmp = pages.get(index);
        int answer = 0;

        while (tmp > 0) {
            answer += (tmp % 10);
            tmp /= 10;
        }
        return answer;
    }
}
