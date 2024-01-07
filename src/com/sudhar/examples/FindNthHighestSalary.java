package com.sudhar.examples;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindNthHighestSalary {

    public static void main(final String[] args) {

        final Map<String, Integer> map = Map.of(
                "sudhar", 1500,
                "john", 1500,
                "anusha", 1600,
                "achu", 1600,
                "sreekanth", 1700,
                "sathia", 1900);

        System.out.println(getNthHighestSalary(4, map));
    }

    private static Map.Entry<Integer, List<String>> getNthHighestSalary(final Integer nHighest, final Map<String, Integer> salaryMap) {
        return salaryMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList().get(nHighest - 1);
    }
}
