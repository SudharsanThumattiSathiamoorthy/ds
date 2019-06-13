package com.sudhar.examples;

public class LongestPathInTheMatrix {

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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
        System.out.println("Maximum consecutive: " + max);

        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        Solution s = new Solution();
        System.out.println(s.longestPath(matrix));

    }

    private static int findPath(int[][] a, int[][] b, int r, int c, int i, int j) {

        if (i == r || j == c) {
            return 0;
        }

        if (b[i][j] > 0) {
            return b[i][j];
        }

        int maxLength = 1;
        for (int[] d: dirs) {
            int newR = d[0] + i, newC = d[1] + j;

            if (newR < 0 || newR == r || newC < 0 || newC == c || (1 + a[i][j] != a[newR][newC])) {
                continue;
            }

            maxLength = Math.max(maxLength, 1 + findPath(a, b, r, c, newR, newC));
        }

        b[i][j]= maxLength;
        return maxLength;

//        if (j - 1 >= 0 && (1 + a[i][j] == a[i][j - 1])) {
//            return b[i][j] = 1 + findPath(a, b, r, c, i, j - 1);
//        }
//
//        if (i - 1 >= 0 && (1 + a[i][j] == a[i - 1][j])) {
//            return b[i][j] = 1 + findPath(a, b, r, c, i - 1, j);
//        }
//
//        if (i + 1 < r && (1 + a[i][j] == a[i + 1][j])) {
//            return b[i][j] = 1 + findPath(a, b, r, c, i + 1, j);
//        }
//
//        if (j + 1 < c && (1 + a[i][j] == a[i][j + 1])) {
//            return b[i][j] = 1 + findPath(a, b, r, c, i, j + 1);
//        }
//        return b[i][j] = 1;
    }
}

class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int[][] cache;

    public int longestPath(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return 0;
        }

        int r = a.length;
        int c = a[0].length;

        cache = new int[r][c];
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int temp = findMaxDistance(a, i, j, r, c);
                max = Math.max(temp, max);
            }
        }
        return max;
    }

    private int findMaxDistance(int[][] a, int i, int j, int r, int c) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }

        int maxLength = 1;

        for (int[] d : dirs) {
            int newR = i + d[0];
            int newC = i + d[1];

            if (newR < 0 || newR == r || newC < 0 || newC == c || a[newR][newC] <= a[i][j]) {
                continue;
            }

            maxLength = Math.max(maxLength, 1 + findMaxDistance(a, newR, newC, r, c));
        }
        cache[i][j] = maxLength;
        return maxLength;
    }
}

//class Solution {
//    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    private int R = 0, C = 0;
//    private int[][] cache;
//
//    public int longestIncreasingPath(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
//            return 0;
//        }
//
//        R = matrix.length;
//        C = matrix[0].length;
//
//        cache = new int[R][C];
//        int maxLen = 1;
//
//        for (int r = 0; r < R; r++) {
//            for (int c = 0; c < C; c++) {
//                maxLen = Math.max(maxLen, helper(matrix, r, c));
//            }
//        }
//        return maxLen;
//    }
//
//    private int helper(int[][] matrix, int r, int c) {
//        if (cache[r][c] > 0){
//            return cache[r][c];
//        }
//
//        int maxLen = 1;
//        for (int[] d : dirs) {
//            int newR = r + d[0], newC = c + d[1];
//            if (newR < 0 || newR == R || newC < 0 || newC == C || matrix[newR][newC] <= matrix[r][c]) {
//                continue;
//            }
//
//            maxLen = Math.max(maxLen, helper(matrix, newR, newC) + 1);
//        }
//
//        cache[r][c] = maxLen;
//        return maxLen;
//    }
//}