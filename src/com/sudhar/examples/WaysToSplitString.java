package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

public class WaysToSplitString {

    // Splitting a string s into s1 and s2 means s = s1+s2.
    // In the first for-loop, count every element characters in s. It means s1 = "" and s2 = s.
    // In the second for-loop, remove character from right and add character to left. Then, compare the keySet of left and right. If both keysets are equal, it means the number of unique characters between s1 and s2 are the same.

    public static int splitStringUniqueChars(String input) {
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        int ans = 0;
        for(char c : input.toCharArray()) right.put(c, right.getOrDefault(c, 0) + 1);
        for(char c : input.toCharArray()) {
            // Move character from right to left
            right.put(c, right.getOrDefault(c, 0) - 1);
            left.put(c, left.getOrDefault(c, 0) + 1);
            if(right.get(c) == 0) break;
            // Compare unique characters
            if(right.keySet().equals(left.keySet())) ans++;
        }
        return ans;
    }
}
