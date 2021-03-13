package com.sudhar.examples;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int end = 0, anchor = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //        Input: S = "ababcbacadefegdehijhklij"
        //        Output: [9,7,8]
        //        Explanation:
        //        The partition is "ababcbaca", "defegde", "hijhklij".
        //                This is a partition so that each letter appears in at most one part.
        //                A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
