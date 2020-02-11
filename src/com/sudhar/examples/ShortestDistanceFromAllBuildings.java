package com.sudhar.examples;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    public static void main(String[] args) {

    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int r = grid.length;
        int c = grid[0].length;

        int[][] dis = new int[r][c];
        int[][] reach = new int[r][c];
        int noOfBuildings = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    findDistanceAndReach(grid, dis, reach, i, j);
                    noOfBuildings++;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0 && reach[i][j] == noOfBuildings) {
                    result = Math.min(result, dis[i][j]);
                }
            }
        }

        return result;
    }

    private void findDistanceAndReach(int[][] grid, int[][] dis, int[][] reach, int i, int j) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        Queue<Integer> qDist = new LinkedList<>();

        q.add(new int[] {i, j});
        qDist.add(1);

        while (!q.isEmpty()) {
            int[] coor  = q.poll();
            int dist = qDist.poll();


            for (int k = 0; k < 4; k++) {
                int x = coor[0] + dx[k];
                int y = coor[1] + dy[k];

                if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0) {
                    grid[x][y] = -1;

                    q.add(new int[] {x, y});
                    qDist.add(dist + 1);

                    dis[x][y] += dist;
                    reach[x][y]++;
                }
            }
        }

        for (int x = 0; x < grid.length; x++) {
            for (int y= 0; y < grid[0].length; y++) {
                if (grid[x][y] == -1) {
                    grid[x][y] = 0;
                }
            }
        }
    }
}
