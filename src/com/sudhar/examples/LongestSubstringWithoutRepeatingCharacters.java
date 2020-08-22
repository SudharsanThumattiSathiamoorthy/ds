package com.sudhar.examples;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.Map;

//Amazon
//        |
//        27
//
//        Facebook
//        |
//        19
//
//        Bloomberg
//        |
//        13
//
//        Apple
//        |
//        11
//
//        Google
//        |
//        10
//
//        Adobe
//        |
//        9
//
//        Microsoft
//        |
//        6
//
//        eBay
//        |
//        5
//
//        Uber
//        |
//        5
//
//        ByteDance
//        |
//        5
//
//        Spotify
//        |
//        4
//
//        Cisco
//        |
//        3
//
//        VMware
//        |
//        3
//
//        Yahoo
//        |
//        2
//
//        Goldman Sachs
//        |
//        2
//
//        Oracle
//        |
//        2
//
//        Yandex
//        |
//        2
//
//        Atlassian
//        |
//        2
public class LongestSubstringWithoutRepeatingCharacters {


    public int substring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = sMap.getOrDefault(c, 0);
            sMap.put(c, count + 1);
        }

        int target = sMap.size();
        int l = 0, r = s.length(), i = 0;

        Map<Character, Integer> wMap = new HashMap<>();
        int count = 0;
        int[] result = new int[3];
        result[0] = 1;

        while (i < r) {
            char c = s.charAt(i);
            int occurrence = wMap.getOrDefault(c, 0);

            if (occurrence == 0) {
                count++;
            }
            wMap.put(c, occurrence + 1);

            while (count == target && l < i) {
                int diff = result[2] - result[1];
                if (result [0] == 1 || i - l + 1 < diff) {
                    result[0] = i - l + 1;
                    result[1] = l;
                    result[2] = i;
                }

                char charToBeRemoved = s.charAt(l);
                int wCount = wMap.get(charToBeRemoved);
                if (wCount - 1 == 0) {
                    count--;
                }
                wMap.put(charToBeRemoved, wCount - 1);
                l++;
            }
            i++;
        }

        System.out.println(s.substring(result[1], result[2] + 1));
        return result[0] == 1 ? 1 :  result[2] - result[1] + 1;

    }

    public static void main(String[] a) {

        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.substring("abcabcbb"));
    }

}
