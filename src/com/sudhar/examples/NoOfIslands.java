package com.sudhar.examples;

public class NoOfIslands {

    public static void main(String[] args) {

        int[][] grid= {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };

        int count = 0, r = grid.length, c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, r, c);
                    count++;
                }
            }
        }

        System.out.println("Count : " + count);
    }

    private static void dfs(int[][] grid, int i, int j, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c) {
            return;
        }

        if (grid[i][j] == 1) {
            grid[i][j] = 0;

            dfs(grid, i+1, j, r, c);
            dfs(grid, i-1, j, r, c);
            dfs(grid, i, j+1, r, c);
            dfs(grid, i, j-1, r, c);
        }
    }
}
