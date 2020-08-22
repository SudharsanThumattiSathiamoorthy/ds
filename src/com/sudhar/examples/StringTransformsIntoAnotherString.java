package com.sudhar.examples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTransformsIntoAnotherString {

    //    Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.
    //
    //    In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
    //
    //            Return true if and only if you can transform str1 into str2.
    //
    //
    //
    //    Example 1:
    //
    //    Input: str1 = "aabcc", str2 = "ccdee"
    //    Output: true
    //    Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
    //            Example 2:
    //
    //    Input: str1 = "leetcode", str2 = "codeleet"
    //    Output: false
    //    Explanation: There is no way to transform str1 to str2.
    //
    //
    //            Note:
    //
    //            1 <= str1.length == str2.length <= 10^4
    //    Both str1 and str2 contain only lowercase English letters.

    // https://leetcode.com/problems/string-transforms-into-another-string/discuss/790619/!!!Java-really-HELPFUL-article-with-illustrations!!!

    class Solution {

        //@para map records all the conversion relation
        //@para set1 records who occured in the string
        //@para set2 records thosed nodes whose indegree >0
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        public boolean canConvert(String str1, String str2) {
            int p = 0;
            while (p <= str1.length() - 1) {
                set1.add(str1.charAt(p));
                if (str1.charAt(p) == (str2.charAt(p))) {
                    p++;
                } else {
                    if (map.containsKey(str1.charAt(p))) {
                        if (map.get(str1.charAt(p)).equals(str2.charAt(p))) {
                            p++;
                        } else //must be one to one relation otherwise return false directly
                        {
                            return false;
                        }
                    } else {
                        set2.add(str2.charAt(p));
                        map.put(str1.charAt(p), str2.charAt(p));
                        p++;
                    }
                }
            }
            if (set1.size() <= 25
                || map.size() <= 1) //at least one node never occurred before or only no loop in the graph
            {
                return true;
            }
            if (map.size() > set2.size())//at least one node out of the loop
            {
                return true;
            }
            return false;
        }
    }

    class Solution2 {

        //@para visited represent which characters occurred in the string
        //@para map records all the conversion relation
        Map<Character, Character> map = new HashMap<>();
        int[] visited = new int[26];

        public boolean canConvert(String str1, String str2) {
            for (int i = 0; i <= 25; i++) {
                visited[i] = 0;
            }
            int p = 0;
            //---------step1 :build the single direction graph----//
            while (p <= str1.length() - 1) {
                visited[str1.charAt(p) - 'a'] = 1;
                if (str1.charAt(p) == (str2.charAt(p))) {
                    p++;
                } else {
                    if (map.containsKey(str1.charAt(p))) {
                        if (map.get(str1.charAt(p)).equals(str2.charAt(p))) {
                            p++;
                        } else
                        //must be one to one relation
                        //otherwise return false directly
                        {
                            return false;
                        }
                    } else {
                        map.put(str1.charAt(p), str2.charAt(p));
                        p++;
                    }
                }
            }
            //-----------------------step 2 check the loop----------//
            //-----2.1 char never occurred before can be used as transfer station-------------//
            int cnt = 0;
            for (int i = 0; i <= 25; i++) {
                cnt += visited[i];
            }
            if (cnt <= 25) {
                return true;
            }
            //---------------2.2 check how many loop and size of each loop----//
            //@para visited is cleared here, to show a node isVisited or not
            //@para total_size : the total number of nodes in loop
            //@para loop : how many loops are in the graph
            //may be you can make optimizations here, using slow and fast pointers.
            //Floyd tortoise and hare algorithm.
            for (int i = 0; i <= 25; i++) {
                visited[i] = 0;
            }
            int total_size = 0;
            int loop = 0;
            for (char c : map.keySet()) {
                if (visited[c - 'a'] == 1) {
                    continue;
                }
                char pre = c;
                visited[c - 'a'] = 1;
                int flag = 0;
                while (map.containsKey(map.get(c))) {
                    c = map.get(c);
                    if (visited[c - 'a'] == 1) {
                        flag = 1;
                        break;
                    }
                    visited[c - 'a'] = 1;
                }
                //when finding one loop, we assign 1 to flag and begin to caculate the size of the loop
                if (flag == 1) {
                    loop++;
                    int size = 0;
                    char ori = c;
                    while (map.containsKey(map.get(c))) {
                        c = map.get(c);
                        size++;
                        if (c == ori) {
                            break;
                        }
                    }
                    total_size += size;
                }
                visited[pre - 'a'] = 0;
            }
            //--------------step 3--------------//
            if (loop == 0) {
                return true;
            } else if (total_size == 26) {
                return false;
            } else if (total_size < 26) {
                if (map.size() > total_size) {
                    return true;
                } else {
                    return false;
                }
            }
            return total_size == 0;
        }
    }

}
