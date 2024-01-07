package com.sudhar.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        int wordSize = words[0].length();

        int totalLen = words.length * wordSize;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        final List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - totalLen; i++) {
            int j = i, count = words.length;
            Map<String, Integer> tempMap = new HashMap<>(map);

            while (j < i + totalLen) {
                String tempWord = s.substring(j, j + wordSize);

                if (!map.containsKey(tempWord) || tempMap.get(tempWord) == 0) {
                    break;
                }

                int cnt = tempMap.get(tempWord);
                tempMap.put(tempWord, cnt - 1);
                count--;
                j = j + wordSize;
            }

            if (count == 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();

        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}
