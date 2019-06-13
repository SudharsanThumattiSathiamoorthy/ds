package com.sudhar.examples;

import java.util.*;

// Time complexity - o(n) Space Complexity O(26 + L * N)
public class AnagramFinder {

    private static String hash(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            hash[index]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < 26; i++) {
            sb.append("#");
            sb.append(hash[i]);
        }
        return sb.toString();
    }

    private static void anagramFinder(final List<String> inputs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String input: inputs) {
            final String hash = hash(input);

            if (map.containsKey(hash)) {
                List<String> words = map.get(hash);
                words.add(input);
            } else {
                List<String> words = new ArrayList<>();
                words.add(input);

                map.put(hash, words);
            }
        }

        map.forEach((key, value) -> System.out.println(value));
    }

    public static void main(final String[] args) {
        List<String> input = List.of("eat", "tea", "tan", "ate", "nat", "bat");

        anagramFinder(input);
    }
}
