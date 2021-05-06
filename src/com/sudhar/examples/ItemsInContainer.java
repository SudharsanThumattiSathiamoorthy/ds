package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsInContainer {

    public static void main(String[] args) {
        String s = "|**|*|*";

        List<List<Integer>> ranges = List.of(List.of(0,4), List.of(1, 6));

        int[] dp = numberOfItems(s, ranges);

        List<Integer> result = new ArrayList<>();

        for (List<Integer> range: ranges) {
            result.add(findRange(range, dp));
        }

        System.out.println(result);
    }

    public static int[] numberOfItems(String s, List<List<Integer>> ranges) {
        int[] dp= new int[s.length() +1];
        char[] c = s.toCharArray();

        dp[0] = 0;
        for (int i =1; i <= s.length(); i++) {
            if (c[i-1] == '*') {
                dp[i] = 1 + dp[i-1];
            } else {
                dp[i] = dp[i-1];
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp;
    }

    private static int findRange(List<Integer> range, int[] dp) {
        return dp[range.get(1) + 1] - dp[range.get(0)];
    }
}
