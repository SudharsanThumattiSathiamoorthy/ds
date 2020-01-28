package com.sudhar.examples;

public class MinimumPathSum {

    public static void main(final String[] args) {
        MinimumPathSum mps = new MinimumPathSum();

        System.out.println(mps.findMinSumPath());
    }

    public int findMinSumPath() {
        int a[][] = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] visited = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                visited[i][j] = -1;
            }
        }

        return findMin(a, 0, 0, visited);
    }

    private int findMin(int[][] a, int i, int j, int[][] visited) {
        if (visited[i][j] != -1) {
            return visited[i][j];
        }

        int min = 0;
        if (i == a.length - 1 && j == a[0].length - 1) {
            min = a[i][j];
        } else if (i == a.length - 1) {
            min = a[i][j] + findMin(a, i, j + 1, visited);
        } else if (j == a[0].length - 1) {
            min = a[i][j] + findMin(a, i + 1, j, visited);
        } else {
            min = a[i][j] + Math.min(findMin(a, i + 1, j, visited), findMin(a, i, j + 1, visited));
        }

        visited[i][j] = min;
        return min;
    }

//    private int findMin(int[][] grid, int x, int y, int[][] visited){
//        if (visited[x][y]!=-1){
//            return visited[x][y];
//        }
//        int min = 0;
//        if (x == grid.length-1 && y == grid[0].length-1){
//            min = grid[x][y];
//        }
//        else if(x == grid.length-1){
//            min = grid[x][y]+findMin(grid, x, y+1, visited);
//        }
//        else if(y == grid[0].length-1){
//            min = grid[x][y]+findMin(grid, x+1, y, visited);
//        }
//        else{
//            min = grid[x][y] + Math.min(findMin(grid, x+1, y, visited), findMin(grid, x, y+1, visited));
//        }
//        visited[x][y]=min;
//        return min;
//    }
}
