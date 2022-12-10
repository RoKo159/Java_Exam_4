package pl.kurs.task3andtask4.app;

import pl.kurs.task3andtask4.exceptions.NoWomanException;
import pl.kurs.task3andtask4.model.Person;
import pl.kurs.task3andtask4.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Runner {
    public static void main(String[] args) throws NoWomanException {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Agata", "Nowak", "Warsaw", 26));
        personList.add(new Person("Maria", "Czarnecka", "Zabrze", 50));
        personList.add(new Person("Karolina", "Kowalska", "Wrocław", 41));
        personList.add(new Person("Daria", "Kowalewska", "Sopot", 22));
        personList.add(new Person("Wiktoria", "Wiśniewska", "Opole", 56));
        personList.add(new Person("Agata", "Dąbrowska", "Legionowo", 22));
        personList.add(new Person("Cezary", "Cezary", "Gdańsk", 23));
        personList.add(new Person("Maciej", "Nowicki", "Legionowo", 41));
        personList.add(new Person("Antoni", "Kaczmarczyk", "Ciechocinek", 24));
        personList.add(new Person("Tomasz", "Problem", "Sosnowiec", 33));
        personList.add(new Person("Arkadiusz", "Sobieraj", "Białystok", 52));
        personList.add(new Person("Konrad", "Marek", "Zielona Góra", 70));


        PersonService personService = new PersonService();
        System.out.println();
        System.out.println(personService.getOldestWomanWithNameEndsLetterA(personList));
        System.out.println();
        System.out.println(personService.getAvgAgeAllPersonsFromList(personList));
        System.out.println();
        System.out.println(personService.getAvgAgeMenFromList(personList));
        System.out.println();
        System.out.println(personService.getAvgAgeWomanFromList(personList));
        System.out.println();
        System.out.println(personService.getCityWithMostPerson(personList));
        System.out.println();
        personService.getListOfAllCites(personList).forEach(x -> System.out.println(x));
        System.out.println();
        System.out.println(personService.getAvgAgeByPredicate(personList, x -> x.getFirstName().endsWith("a")));

        System.out.println("TreeSet nie zachowuje duplikatów w związku z tym nie wyświetli nam się osoby w tym samym wieku");
        TreeSet<Person> personTreeSet = new TreeSet<>();
        personTreeSet.addAll(personList);
        personTreeSet.forEach(x -> System.out.println(x));

    }
}
