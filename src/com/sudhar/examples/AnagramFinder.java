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
    public int hashCode() {
        return Objects.hash(count, length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Anagram a = (Anagram) o;
        return this.count == a.count && this.length == a.length;
    }
}

public class AnagramFinder {

    private static String findCount(String word) {
        int[] count = new int[26];

        char[] c = word.toCharArray();
        Arrays.sort(c);

        for (int i = 0; i < c.length; i++) {
            count[indexOf(c[i])]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            sb.append("#");
            sb.append(indexOf(c[i]));
        }
        return sb.toString();
    }

    private static int indexOf(char c) {
        return c - 'a';
    }

    private static void anagramFinder(List<String> words) {
        if (words == null || words.size() == 0) {
            return;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            if (word == null || word.length() == 0) {
                continue;
            }

            String count = findCount(word);

            if (map.containsKey(count)) {
                List<String> existingWords = map.get(count);
                existingWords.add(word);
            } else {
                List<String> existingWords = new ArrayList<>();
                existingWords.add(word);

                map.put(count, existingWords);
            }
        }

        map.entrySet().stream()
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    public static void main(final String[] args) {

        List<String> input = List.of("eat", "tea", "tan", "ate", "nat", "bat");

        anagramFinder(input);
    }
}
