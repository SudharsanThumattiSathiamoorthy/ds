package com.sudhar.examples;

import java.util.Collections;
import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

//    Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
//
//    Example 1:
//
//    Input: "eceba"
//    Output: 3
//    Explanation: t is "ece" which its length is 3.
//    Example 2:
//
//    Input: "ccaabbb"
//    Output: 5
//    Explanation: t is "aabbb" which its length is 5.

    class Solution1 {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int n = s.length();
            if (n < 3) return n;

            // sliding window left and right pointers
            int left = 0;
            int right = 0;
            // hashmap character -> its rightmost position
            // in the sliding window
            HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

            int max_len = 2;

            while (right < n) {
                // slidewindow contains less than 3 characters
                if (hashmap.size() < 3)
                    hashmap.put(s.charAt(right), right++);

                // slidewindow contains 3 characters
                if (hashmap.size() == 3) {
                    // delete the leftmost character
                    int del_idx = Collections.min(hashmap.values());
                    hashmap.remove(s.charAt(del_idx));
                    // move left pointer of the slidewindow
                    left = del_idx + 1;
                }

                max_len = Math.max(max_len, right - left);
            }
            return max_len;
        }
    }

}
