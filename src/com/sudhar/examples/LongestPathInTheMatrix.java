package com.sudhar.examples;

public class LongestPathInTheMatrix {

    public static void main(final String... args) {
        int a[][] = {
                {1, 2, 3, 4},
                {2, 2, 3, 4},
                {3, 2, 3, 4},
                {4, 5, 6, 7},
        };

        int b[][] = new int[a.length][a[0].length];
        int max = 1, temp = 0;

        int r = a.length, c = a[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp = findPath(a, b, r, c, i, j);

                if (temp > max) {
                    max = temp;
                }
            }
        }
        System.out.println(max);
    }

    private static int findPath(int[][] a, int[][] b, int r, int c, int i, int j) {

        if (i == r || j == c) {
            return 0;
        }

        if (b[i][j] == 1) {
            return 0;
        }

        if (j - 1 >= 0 && (1 + a[i][j] == a[i][j - 1])) {
            return b[i][j] = 1 + findPath(a, b, r, c, i, j - 1);
        }

        if (i - 1 >= 0 && (1 + a[i][j] == a[i - 1][j])) {
            return b[i][j] = 1 + findPath(a, b, r, c, i - 1, j);
        }

        if (i + 1 < r && (1 + a[i][j] == a[i + 1][j])) {
            return b[i][j] = 1 + findPath(a, b, r, c, i + 1, j);
        }

        if (j + 1 < c && (1 + a[i][j] == a[i][j + 1])) {
            return b[i][j] = 1 + findPath(a, b, r, c, i, j + 1);
        }
        return b[i][j] = 1;
    }
}
