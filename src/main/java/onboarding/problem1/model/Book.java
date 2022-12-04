package onboarding.problem1.model;

import onboarding.problem1.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private List<Integer> pages;

    public Book(List<Integer> pages){
        Validator.validatePages(pages);
        this.pages = new ArrayList<>(pages);
    }
}
