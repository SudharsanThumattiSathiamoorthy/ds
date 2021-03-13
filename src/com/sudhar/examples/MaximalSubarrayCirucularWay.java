package com.sudhar.examples;

import java.util.Arrays;

public class MaximalSubarrayCirucularWay {

    public int maxSubarraySumCircular(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        if (a.length == 1) {
            return a[0];
        }

        int sum = Arrays.stream(a).sum();

        int ans1 = kadane(a, 0, a.length -1, 1);
        int ans2 = sum + kadane(a, 1, a.length -1, -1);
        int ans3 = sum+ kadane(a, 0, a.length -2, -1);


        return Math.max(ans1, Math.max(ans2, ans3));
    }

    public int kadane(int[] A, int i, int j, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int ans = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            cur = sign * A[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
