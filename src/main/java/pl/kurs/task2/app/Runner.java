package pl.kurs.task2.app;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(4, 8, 6, 2, 1, 10, 11, 12, 13, 14);

        System.out.println(getTopFiveIntegersFromTheList(integerList));
    }


    static List<Integer> getTopFiveIntegersFromTheList(List<Integer> integerList) {
        return Optional.of(
                Optional.ofNullable(integerList)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .filter(Objects::nonNull)
                        .sorted(Comparator.reverseOrder())
                        .limit(5)
                        .collect(Collectors.toList()))
                .filter(x -> x.size() >= 5)
                .orElseGet(Collections::emptyList);
    }

}
