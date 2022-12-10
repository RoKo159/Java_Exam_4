package pl.kurs.task1.app;


import pl.kurs.task1.exceptions.InvlaidPeselException;
import pl.kurs.task1.service.NameAndPeselNumber;

public class Runner {
    public static void main(String[] args) throws InvlaidPeselException {
        NameAndPeselNumber nameAndPeselNumber = new NameAndPeselNumber();
        nameAndPeselNumber.getNumberHowManyLettersNameHas();
        nameAndPeselNumber.getBirthDateFromPeselNumber();

    }
}
