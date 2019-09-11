package com.sudhar.examples;

public class MinSumInMatrix {

    public static void main(final String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(findMinSum(grid));
    }

    private static int findMinSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;

        int[][] result = new int[r][c];
        result[0][0] = grid[0][0];

        for (int i = 1; i < r; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < c; j++) {
            result[0][j] = result[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                result[i][j] = grid[i][j] + Math.min(result[i - 1][j], result[i][j - 1]);
            }
        }

        return result[r - 1][c - 1];
    }
}
