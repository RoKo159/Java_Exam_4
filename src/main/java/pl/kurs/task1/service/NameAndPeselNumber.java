package pl.kurs.task1.service;

import pl.kurs.task1.exceptions.InvlaidPeselException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class NameAndPeselNumber {

    public Optional<Integer> getNumberHowManyLettersNameHas() {
        System.out.println("Write your name:");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        Integer length = Optional.ofNullable(name)
                .map(x -> x.length())
                .orElse(0);
        System.out.println("Name has " + length + " letters");
        return Optional.of(length);
    }

    public Optional<LocalDate> getBirthDateFromPeselNumber() throws InvlaidPeselException {
        System.out.println("Write your pesel number:");
        Scanner peselScanner = new Scanner(System.in);
        String peselNumber = peselScanner.nextLine();
        LocalDate localDate = Optional.ofNullable(peselNumber)
                .filter(x -> x.matches("\\d{11}"))
                .map(x -> getDateFromPesel(x))
                .orElseThrow((() -> new InvlaidPeselException("Invalid pesel number")));
        System.out.println("Your birth date is: " + localDate);
        return Optional.ofNullable(localDate);
    }

    static LocalDate getDateFromPesel(String pesel) {
        return LocalDate.of(
                Integer.parseInt("19" + pesel.substring(0, 2)),
                Integer.parseInt(pesel.substring(2, 4)),
                Integer.parseInt(pesel.substring(4, 6))
        );
    }
}
