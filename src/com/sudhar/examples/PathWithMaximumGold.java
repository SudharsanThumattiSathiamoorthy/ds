package com.sudhar.examples;

public class PathWithMaximumGold {

    int r;
    int c;

    boolean[][] visited;

    int maxGold = Integer.MIN_VALUE;


    public int getMaximumGold(int[][] grid) {
        if (grid  == null || grid.length == 0) {
            return -1;
        }

        r = grid.length;
        c = grid[0].length;

        visited  = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (!visited[i][j] && grid[i][j] != 0) {
                    // dfs(grid, i, j, 0);
                    dfs(i, j, grid, 0);
                }
            }
        }

        return maxGold;
    }

    private void dfs(int i, int j, int[][] grid, int collectedGold) {
        if (i < 0 || i >= r || j < 0 || j >= c || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        collectedGold += grid[i][j];

        dfs(i + 1, j, grid, collectedGold);
        dfs(i - 1, j, grid, collectedGold);
        dfs(i, j + 1, grid, collectedGold);
        dfs(i, j - 1, grid, collectedGold);

        maxGold = Math.max(maxGold, collectedGold);

        visited[i][j] = false;
        collectedGold -= grid[i][j];
    }
}
