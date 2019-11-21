package com.sudhar.examples;

// Refer PaintFences.. both are similar
public class NoOf1InRanges {

    static int[] dp;
    public static void main(String[] args) {
        int[] a = {0, 1, 1, 1, 0, 0};
        noOf1s(a);

        System.out.println(noOf1(0, 3));
        System.out.println(noOf1(3,5 ));
    }

    public static void noOf1s(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        dp = new int[a.length+1];

        for (int i = 1; i < dp.length; i++) {
            if (a[i-1] == 1) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }
    }

    public static int noOf1(int i, int j) {
        return dp[j+1] - dp[i];
    }
}
