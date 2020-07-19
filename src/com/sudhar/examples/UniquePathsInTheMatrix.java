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

    // Another solution.
    private int uniquePaths(int[][] a, int i, int j) {
        if (i == 0|| j == 0 || a[i][j] == 0) {
            return 0;
        }

        if (i == a.length -1 && j == a[0].length - 1 && a[i][j] == 1) {
            return 1;
        }

        return uniquePaths(a, i+1, j) + uniquePaths(a, i-1, j);
    }
}
