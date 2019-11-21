package com.sudhar.examples;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumIntervalOverlap {

    public static void main(final String[] args) {


    }

    public static int maxOverlap(int[] start, int[] end, int n) {
        if (start == null || end == null || start.length == 0 || end.length == 0) {
            return 0;
        }

        int maxStart = Arrays.stream(start).max().getAsInt();
        int maxEnd = Arrays.stream(end).max().getAsInt();

        int max = Math.max(maxStart, maxEnd);

        int[] dp = new int[max + 1];

        IntStream.range(0, start.length)
                .forEach(i -> {
                    ++dp[start[i]];
                    --dp[end[i] + 1];
                });

        int maxIntervals = Integer.MIN_VALUE, temp = 0;

        for (int i = 0; i < dp.length; i++) {
            temp += dp[i];
            maxIntervals = Math.max(temp, maxIntervals);
        }

        return maxIntervals;
    }
}
