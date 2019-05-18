package com.sudhar.examples;

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

        for (int i=0; i < r; i++) {
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
            for (int j=0; j < a[0].length; j++) {
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

        fillDistances(a, visited, i+1, j, r, c, distance +1);
        fillDistances(a, visited, i-1, j, r, c, distance +1);
        fillDistances(a, visited, i, j+1, r, c, distance +1);
        fillDistances(a, visited, i, j-1, r, c, distance +1);

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
}
