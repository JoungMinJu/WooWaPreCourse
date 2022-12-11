package onboarding.problem6.service;

import onboarding.problem6.model.Person;
import onboarding.problem6.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnrollService {

    public List<Person> getPersons(String input){
        List<Person> persons = new ArrayList<>();
        List<String> inputPersons = Arrays.asList(input.split(","));
        Validator.validateNumberOfPerson(inputPersons);
        for (String inputPerson : inputPersons) {
            List<String> personParams = Arrays.asList(inputPerson.split(" "));
            persons.add(getPerson(personParams));
        }
        return persons;
    }

    private Person getPerson(List<String> input){
        Validator.validateNumberOfPersonParam(input);
        Validator.validateEmail(input.get(0));
        Validator.validateNickname(input.get(1));
        return new Person(input.get(0), input.get(1));
    }
}
