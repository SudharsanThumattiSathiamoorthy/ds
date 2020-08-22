package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RearrangeStringkDistanceApart {

    public String rearrangeString(String s, int k) {
        if (s.length() <= 1 || k <= 1) return s;
        int[] freqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (freqs[b] != freqs[a] ? freqs[b] - freqs[a] : a - b));
        // 也可以
        // PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> (b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]));
        for (int i = 0; i < 26; i++) {
            if (freqs[i] > 0) {
                pq.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            List<Integer> chars = new ArrayList<>();
            // form a k pair
            for (int i = 0; i < k; i++) {
                int cur = pq.poll();
                sb.append((char)(cur + 'a'));
                chars.add(cur);
                if (pq.isEmpty()) {
                    if (i != k - 1 && sb.length() != s.length()) return "";
                    break;
                }
            }
            // re-add chars that has freq > 0
            for (int ch : chars) {
                if (--freqs[ch] > 0) {
                    pq.offer(ch);
                }
            }
        }

        return sb.toString();
    }


}

//Example 1:
//
//        Input: s = "aabbcc", k = 3
//        Output: "abcabc"
//        Explanation: The same letters are at least distance 3 from each other.
//        Example 2:
//
//        Input: s = "aaabc", k = 3
//        Output: ""
//        Explanation: It is not possible to rearrange the string.
//        Example 3:
//
//        Input: s = "aaadbbcc", k = 2
//        Output: "abacabcd"
//        Explanation: The same letters are at least distance 2 from each other.
