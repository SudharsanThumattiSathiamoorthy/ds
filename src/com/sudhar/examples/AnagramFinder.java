package com.sudhar.examples;

import java.util.*;

class Anagram {
    int count;
    int length;

    Anagram(int count, int length) {
        this.count = count;
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anagram anagram = (Anagram) o;
        return count == anagram.count &&
                length == anagram.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, length);
    }
}

public class AnagramFinder {

    private static int indexOf(char c) {
        return 'a' - c;
    }

    private static int findCount(String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            count += indexOf(word.charAt(i));
        }

        return count;
    }

    public static void main(final String[] args) {

        List<String> input = List.of("geeksquiz", "geeksforgeeks",
                "abcd", "forgeeksgeeks", "rats", "arts",
                "zuiqkeegs");

        anagramPair(input);
    }

    private static void anagramPair(final List<String> input) {
        final Map<Anagram, List<String>> map = new HashMap<>();
        input.forEach(word -> {

            int count = findCount(word);

            final Anagram anagram = new Anagram(count, word.length());

            if (map.containsKey(anagram)) {
                final List<String> words = map.get(anagram);
                words.add(word);
            } else {
                final List<String> words = new ArrayList<>();
                words.add(word);

                map.put(anagram, words);
            }
        });

        map.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .map(Map.Entry::getValue)
                .forEach(System.out::println);

    }
}
