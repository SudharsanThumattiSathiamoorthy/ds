package com.sudhar.examples;

import java.util.Arrays;

public class NoOfChairs {

    public static void main(String[] args) {

    }

    public int noOfChairs(int[] s, int[] e) {

        if (s == null || e == null ) {
            return -1;
        }

        int maxA = Arrays.stream(s).max().getAsInt();
        int maxB = Arrays.stream(e).max().getAsInt();

        int max = Math.max(maxA, maxB);

        int[] dp = new int[max + 1];

        for (int i = 0; i < s.length; i++) {
            ++dp[s[i]];
            --dp[e[i] + 1];
        }

        int noOfChairs = 0, temp = 0;
        for (int i = 0; i < dp.length; i++) {
            temp += dp[i];
            noOfChairs = Math.max(temp, noOfChairs);
        }

        return noOfChairs;
    }

}
