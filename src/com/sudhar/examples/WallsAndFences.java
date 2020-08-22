package com.sudhar.examples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/walls-and-gates/solution/
public class WallsAndFences {

    private static final int a[][] =
            {
                    {-10, -1, 0, -10},
                    {-10, -10, -10, -1},
                    {-10, -1, -10, -1},
                    {0, -1, -10, -10}
            };

    private static void wallsAndFences(int[][] a) {
        if (a == null) {
            return;
        }


        int r = a.length;
        int c = a[0].length;

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] == 0) {
                    fillDistances(a, visited, i, j, r, c, 0);
                }
            }
        }

        printArray(a);
    }

    private static void printArray(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillDistances(int[][] a, boolean[][] visited, int i, int j, int r, int c, int distance) {

        if (i < 0 || i >= r || j < 0 || j >= c) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        if (a[i][j] == -1) {
            return;
        }

        visited[i][j] = true;

        if (a[i][j] == -10) {
            a[i][j] = distance;
        } else {

            a[i][j] = distance > a[i][j] ? a[i][j] : distance;
        }

        fillDistances(a, visited, i + 1, j, r, c, distance + 1);
        fillDistances(a, visited, i - 1, j, r, c, distance + 1);
        fillDistances(a, visited, i, j + 1, r, c, distance + 1);
        fillDistances(a, visited, i, j - 1, r, c, distance + 1);

        visited[i][j] = false;
    }

    public static void main(final String[] args) {
//
//        INF  -1  0  INF
//        INF INF INF  -1
//        INF  -1 INF  -1
//        0  -1 INF INF


        wallsAndFences(a);


    }


    // Leetcode solutions. - BFS Approach.
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}
