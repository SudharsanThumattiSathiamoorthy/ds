package com.sudhar.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    class Solution {
        public boolean wordPattern(String pattern, String str) {
            if (pattern == null || str == null) {
                return false;
            }

            Map<Character, String> map = new HashMap<>();
            Set<String> visited = new HashSet<>();
            String[] words = str.split(" ");

            if (words.length != pattern.length()) {
                return false;
            }

            for (int i = 0; i < words.length; i++) {
                char c = pattern.charAt(i);

                if (!map.containsKey(c)) {

                    if (visited.contains(words[i])) {
                        return false;
                    }
                    map.put(c, words[i]);
                    visited.add(words[i]);
                } else {
                    String expected = map.get(c);
                    if (!expected.equals(words[i])) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
