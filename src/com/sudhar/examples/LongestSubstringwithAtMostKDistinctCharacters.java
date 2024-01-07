package com.sudhar.examples;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

//    Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
//            Example 1:
//
//    Input: s = "eceba", k = 2
//    Output: 3
//    Explanation: T is "ece" which its length is 3.
//    Example 2:
//
//    Input: s = "aa", k = 1
//    Output: 2
//    Explanation: T is "aa" which its length is 2.

//    Approach 1: Sliding Window + Hashmap.
//            Intuition
//
//    Let's use here the logic from the more simple problem with at most two distinct characters.
//
//    To solve the problem in one pass let's use here sliding window approach with two set pointers left and right serving as the window boundaries.
//
//    The idea is to set both pointers in the position 0 and then move right pointer to the right while the window contains not more than k distinct characters. If at some point we've got k + 1 distinct characters, let's move left pointer to keep not more than k + 1 distinct characters in the window.

//    For example, using this hashmap one knows that the rightmost position of character O in "LOVELEE" window is 1 and so one has to move left pointer in the position 1 + 1 = 2 to exclude the character O from the sliding window.
//
//            Algorithm
//
//    Now one could write down the algortihm.
//
//            Return 0 if the string is empty or k is equal to zero.
//    Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring length max_len = 1.
//    While right pointer is less than N:
//    Add the current character s[right] in the hashmap and move right pointer to the right.
//    If hashmap contains k + 1 distinct characters, remove the leftmost character from the hashmap and move the left pointer so that sliding window contains again k distinct characters only.
//    Update max_len.

    // Approach 1: Sliding Window + Hashmap.
    class Solution1 {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int n = s.length();
            if (n*k == 0) return 0;

            // sliding window left and right pointers
            int left = 0;
            int right = 0;
            // hashmap character -> its rightmost position
            // in the sliding window
            HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

            int max_len = 1;

            while (right < n) {
                // add new character and move right pointer
                hashmap.put(s.charAt(right), right++);

                // slidewindow contains 3 characters
                if (hashmap.size() == k + 1) {
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

    // Approach 2: Sliding Window + Ordered Dictionary.

//    Algorithm
//
//    Let's use ordered dictionary instead of standard hashmap to trim the algorithm from the approach 1 :
//
//    Return 0 if the string is empty or k is equal to zero.
//    Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring length max_len = 1.
//    While right pointer is less than N:
//    If the current character s[right] is already in the ordered dictionary hashmap -- delete it, to ensure that the first key in hashmap is the leftmost character.
//    Add the current character s[right] in the ordered dictionary and move right pointer to the right.
//    If ordered dictionary hashmap contains k + 1 distinct characters, remove the leftmost one and move the left pointer so that sliding window contains again k distinct characters only.
//    Update max_len.

    class Solution2 {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int n = s.length();
            if (n*k == 0) return 0;

            // sliding window left and right pointers
            int left = 0;
            int right = 0;
            // hashmap character -> its rightmost position
            // in the sliding window
            LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);

            int max_len = 1;

            while (right < n) {
                Character character = s.charAt(right);
                // if character is already in the hashmap -
                // delete it, so that after insert it becomes
                // the rightmost element in the hashmap
                if (hashmap.containsKey(character))
                    hashmap.remove(character);
                hashmap.put(character, right++);

                // slidewindow contains k + 1 characters
                if (hashmap.size() == k + 1) {
                    // delete the leftmost character
                    Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
                    hashmap.remove(leftmost.getKey());
                    // move left pointer of the slidewindow
                    left = leftmost.getValue() + 1;
                }

                max_len = Math.max(max_len, right - left);
            }
            return max_len;
        }
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        // char => its count in window
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            // if distinct chars more than k
            if (map.size() > k) {
                maxLen = Math.max(maxLen, right - left);

                // Shrink the window size
                while (map.size() > k) { // can be done by another counter variable
                    char leftChar = s.charAt(left);
                    int freq = map.get(leftChar);
                    if (freq == 1) {
                        map.remove(leftChar); // @note: remove by key
                    } else {
                        map.put(leftChar, freq - 1);
                    }
                    left++;
                }
            }
        }

        // @note: final check
        if (left < s.length()) {
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
