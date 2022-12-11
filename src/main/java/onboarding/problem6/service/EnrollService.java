package onboarding.problem6.service;

import onboarding.problem6.model.Person;
import onboarding.problem6.util.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class EnrollService {
    Map<String, List<Person>> twoCharacterToPerson;

    public List<Person> getPersons(String input) {
        List<Person> persons = new ArrayList<>();
        List<String> inputPersons = Arrays.asList(input.split(","));
        Validator.validateNumberOfPerson(inputPersons);
        for (String inputPerson : inputPersons) {
            List<String> personParams = Arrays.asList(inputPerson.split(" "));
            persons.add(getPerson(personParams));
        }
        return persons;
    }

    private Person getPerson(List<String> input) {
        Validator.validateNumberOfPersonParam(input);
        Validator.validateEmail(input.get(0));
        Validator.validateNickname(input.get(1));
        return new Person(input.get(0), input.get(1));
    }

    public List<String> getDuplicatedNickNamePersonEmails(List<Person> persons) {
        initTwoCharacterToPerson();
        for (Person person : persons) {
            updateTwoCharacterToPerson(person);
        }
        List<String> emails = checkAndGetDuplicatedNickNamePersonEmails();
        return emails.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    private void initTwoCharacterToPerson() {
        twoCharacterToPerson = new HashMap<>();
    }

    private void updateTwoCharacterToPerson(Person person) {
        String nickname = person.getNickname();

        for (int index = 0; index <= nickname.length() - 2; index++) {
            String substring = nickname.substring(index, index + 2);
            if (!twoCharacterToPerson.containsKey(substring)) {
                twoCharacterToPerson.put(substring, new ArrayList<>());
            }
            twoCharacterToPerson.get(substring).add(person);
        }
    }

    private List<String> checkAndGetDuplicatedNickNamePersonEmails() {
        List<String> emails = new ArrayList<>();
        for (String key : twoCharacterToPerson.keySet()) {
            List<Person> persons = twoCharacterToPerson.get(key);
            if (persons.size() < 2) {
                continue;
            }
            emails.addAll(getEmails(persons));
        }
        return emails;
    }

    private List<String> getEmails(List<Person> persons) {
        List<String> emails = new ArrayList<>();
        for (Person person : persons) {
            emails.add(person.getEmail());
        }
        return emails;
    }


}
