package com.sudhar.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTransformIntoAnotherString {

    public static void main(String[] args) {
        StringTransformIntoAnotherString s = new StringTransformIntoAnotherString();

        System.out.println(s.canConvert("aabcc", "ccdee"));
        System.out.println(s.canConvert("leetcode", "codeleet"));
    }

    public boolean canConvert(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i< s1.length(); i++) {
            set.add(s1.charAt(i));

            if (map.containsKey(s1.charAt(i)) && map.get(s1.charAt(i)) != s2.charAt(i)) {
                return false;
            }

            map.put(s1.charAt(i), s2.charAt(i));
        }

        if (s1.equals(s2) && set.size() == 26 && map.size() == 26) {
            return false;
        }

        return true;
    }

}
