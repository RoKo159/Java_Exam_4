package pl.kurs.task3andtask4.service;

import pl.kurs.task3andtask4.model.Person;
import pl.kurs.task3andtask4.exceptions.NoWomanException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public Person getOldestWomanWithNameEndsLetterA(List<Person> personlist) throws NoWomanException {
        return Optional.ofNullable(personlist)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomanException("No woman in list"));
    }

    public double getAvgAgeAllPersonsFromList(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToLong(x -> x.getAge())
                .average()
                .orElse(0);
    }

    public double getAvgAgeMenFromList(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> !x.getFirstName().endsWith("a"))
                .mapToLong(x -> x.getAge())
                .average()
                .orElse(0);
    }

    public double getAvgAgeWomanFromList(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstName().endsWith("a"))
                .mapToLong(x -> x.getAge())
                .average()
                .orElse(0);
    }


    public double getAvgAgeByPredicate(List<Person> personList, Predicate<Person> predicate) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(
                        x -> Arrays.stream(Person.class.getDeclaredFields()).allMatch(Objects::nonNull)
                )
                .filter(predicate)
                .mapToLong(x -> x.getAge())
                .average()
                .orElse(0);
    }

    public Optional<String> getCityWithMostPerson(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Person::getCity))
                .entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue().size()))
                .map(Map.Entry::getKey);
    }

    public List<String> getListOfAllCites(List<Person> personList) {
        return personList.stream()
                .map(x -> x.getCity())
                .distinct()
                .collect(Collectors.toList());
    }
}
