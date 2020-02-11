package com.sudhar.examples;

public class UniquePathsInTheMatrix {

    public static void main(String[] args) {
        int m = 4, n = 4;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0|| j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println(dp[m-1][n-1]);
    }
}
