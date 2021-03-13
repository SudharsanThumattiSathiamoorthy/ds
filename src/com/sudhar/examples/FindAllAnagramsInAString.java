package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();

        // s: "cbaebabacd" p: "abc"
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26], sCount = new int[26];

        for (int i = 0; i < p.length(); i++) pCount[p.charAt(i) - 'a']++;

        int left = 0, right = 0;
        while (right < p.length()) sCount[s.charAt(right++) - 'a']++;

        while (right < s.length()) {
            if (isCountEqual(pCount, sCount)) result.add(left);
            sCount[s.charAt(left) - 'a']--;
            sCount[s.charAt(right)  - 'a']++;
            left++;
            right++;
        }

        if (isCountEqual(pCount, sCount)) result.add(left);
        return result;
    }


    private boolean isCountEqual(int[] pCount, int[] sCount) {
        for (int i = 0; i <  26; i++) {
            if (pCount[i] != sCount[i]) return false;
        }
        return true;
    }
}
