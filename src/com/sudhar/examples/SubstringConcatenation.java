package com.sudhar.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {

    public static void main(final String[] args){
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || s.length() < words[0].length())
            return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int window = 0;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            window += word.length();
        }
        List result = new ArrayList<>();
        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            int index = i;
            while (index + window <= s.length()) {
                Map<String, Integer> newMap = new HashMap<>(map);
                int endIndex = index + window, interrupt = 0;
                while (endIndex > index) {
                    String str = s.substring(endIndex - wordLen, endIndex);
                    if (!newMap.containsKey(str) || newMap.get(str) <= 0) {
                        interrupt = 1;
                        break;
                    }
                    newMap.put(str, newMap.get(str) - 1);
                    endIndex -= wordLen;
                }
                if (interrupt == 1) {
                    index = endIndex;
                    continue;
                }
                result.add(index);
                index += wordLen;
            }
        }
        return result;
    }
}
