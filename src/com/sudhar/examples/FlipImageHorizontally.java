package com.sudhar.examples;

public class FlipImageHorizontally {

    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };

        flipImage(a);

        MatrixUtil.printMatrix(a);
    }

    private static void flipImage(int[][] a) {
        if (a == null || a.length == 0) {
            return;
        }

        for (int i = 0; i < a.length; i++) {
            int rowLen = a.length;
            int[] temp = new int[a[i].length];
            for (int j = rowLen -1; j >= 0; j--) {
                temp[rowLen-j-1] = 1 - a[i][j];
            }
            a[i] = temp;
        }
    }
}
