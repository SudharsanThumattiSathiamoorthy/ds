package com.sudhar.examples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "com.sudhar.examples.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Java8Example {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("one");

        System.out.println(list
                .stream()
                .limit(4)
                .distinct()
                .collect(Collectors.joining(",")));

        List<Integer> l = Arrays.asList(1, 2, 3, 4, 4);

        System.out.println(l.stream()
                .reduce(0, (prev, num) -> {
                    return prev + num;
                }));

        System.out.println(l.stream().distinct().reduce(0, (prev, curr) -> prev + curr));

        l.stream().reduce(0, (prev, curr) -> prev + curr);

        System.out.println(list.stream()
                .filter(Objects::nonNull)
                .map(v -> v.toLowerCase())
                .map(v -> v.toUpperCase())
                .map(v -> v.substring(0, 3))
                .count());

        Map<Integer, Integer> map = Map.of(1, 2, 3, 4, 5, 6);

        System.out.println(map.entrySet().stream()
                .filter(e -> e.getKey() % 2 != 0)
                .count());

        System.out.println(map.entrySet().stream()
                .filter(e -> e.getKey() % 2 != 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        Function<Integer, Integer> add = (n1) -> n1 + n1;
        Function<Integer, Integer> multiply = (n2) -> n2 * 2;

        System.out.println(add.andThen(multiply).apply(3));

        System.out.println(map.entrySet().stream()
                .filter(entrySet -> entrySet.getKey() % 2 == 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        System.out.println(map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getKey)));

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Sudh", 32));
        personList.add(new Person("Sudh", 31));

        personList.add(new Person("mona", 34));
        personList.add(new Person("Achu", 2));
        personList.add(new Person("anu", 28));

        personList.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));

        //System.out.println(personList.stream().sorted().collect(Collectors.groupingBy(Person::getAge, Collectors.groupingBy(Person::getName))));

        System.out.println(personList.stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2)));

        System.out.println(l.stream()
                .reduce((i1, i2) -> i1 + i2).get());

        String s = "3[a]2[bc]";

        for (char c : s.toCharArray()) {
            System.out.println(c + " " + Character.isDigit(c));
        }
    }
}

final class Singleton {
    private Singleton() {

    }

    private Singleton instance;

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static synchronized Singleton getSingleton() {
        return SingletonInstance.INSTANCE;
    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
                return instance;
            }
        }
        return instance;
    }


}

