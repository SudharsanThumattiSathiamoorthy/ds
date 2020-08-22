package com.sudhar.examples;

import java.util.HashMap;
import java.util.Map;

public class MaximalSubarrayEqualTo0 {

    public static void main(final String[] args) {
        int[] a = {15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println(findMaximalSubarray(a));
    }

    private static int findMaximalSubarray(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if (a[i] == 0 && max == 0) {
                max = 1;
            }

            if (sum == 0) {
                max = i + 1;
            }

            Integer prev = map.get(sum);
            if (prev != null) {
                max = Math.max(max, i - prev);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
