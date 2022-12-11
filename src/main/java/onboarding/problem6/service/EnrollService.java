package onboarding.problem6.service;

import onboarding.problem6.model.Person;
import onboarding.problem6.util.Validator;

import java.util.*;
import java.util.stream.Collectors;

import static onboarding.problem6.util.Constants.*;

public class EnrollService {
    Map<String, List<Person>> twoCharacterToPerson;

    public List<Person> getPersons(String input) {
        List<Person> persons = new ArrayList<>();
        List<String> inputPersons = Arrays.asList(input.split(PERSON_SEPARATOR));
        Validator.validateNumberOfPerson(inputPersons);
        for (String inputPerson : inputPersons) {
            List<String> personParams = Arrays.asList(inputPerson.split(PARAMETER_SEPARATOR));
            persons.add(getPerson(personParams));
        }
        return persons;
    }

    private Person getPerson(List<String> input) {
        Validator.validateNumberOfPersonParam(input);
        String email = getEmail(input);
        String nickName = getNickName(input);
        return new Person(email, nickName);
    }

    private String getEmail(List<String> input) {
        Validator.validateEmail(input.get(EMAIL_INDEX));
        return input.get(EMAIL_INDEX);
    }

    private String getNickName(List<String> input) {
        Validator.validateNickname(input.get(NICKNAME_INDEX));
        return input.get(NICKNAME_INDEX);
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

        for (int index = 0; index <= nickname.length() - TWO_CHARACTER_REFERENCE_VALUE; index++) {
            String substring = nickname.substring(index, index + TWO_CHARACTER_REFERENCE_VALUE);
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
            if (persons.size() < DUPLICATED_REFERENCE_VALUE) {
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
