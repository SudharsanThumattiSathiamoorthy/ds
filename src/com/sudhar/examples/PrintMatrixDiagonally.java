package com.sudhar.examples;

import java.util.Arrays;

public class PrintMatrixDiagonally {

    public static void main(String... args) {
        // Java program to print matrix in diagonal order
        // Initialize matrix
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};

        int[][] mat1 = {{2, 3}};
        PrintMatrixDiagonally pmd = new PrintMatrixDiagonally();
        // System.out.println(Arrays.toString(pmd.findDiagonalOrder(mat)));
        System.out.println(Arrays.toString(pmd.findDiagonalOrder(mat1)));

    }

    public int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;

        // The final result array
        int[] result = new int[N * M];
        int r = 0;

        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {

            // First and foremost, add the current element to
            // the result matrix.
            result[r++] = matrix[row][column];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {

                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0);
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // Flip the direction
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }

//    private int[] findDiagonalOrder(int[][] mat) {
//        // n - size
//        // mode - switch to derive up/down traversal
//        // it - iterator count - increases until it
//        // reaches n and then decreases
//        int c = mat[0].length, mode = 0, lower = 0;
//        int[] result = new int[mat.length * mat[0].length];
//        int index = 0;
//
//        // 2n will be the number of iterations
//        for (int t = 0; t < (2 * c - 1); t++) {
//            int t1 = t;
//            if (t1 >= c) {
//                mode++;
//                t1 = c - 1;
//                lower++;
//            } else {
//                lower = 0;
//            }
//            for (int i = t1; i >= lower; i--) {
//                if ((t1 + mode) % 2 == 0) {
//                    // result[index++] = mat[i][t1 + lower - i];
//                    System.out.println(mat[i][t1 + lower - i]);
//                } else {
//                    // result[index++] = mat[t1 + lower - i][i];
//                    System.out.println(mat[t1 + lower - i][i]);
//                }
//            }
//        }
//
//        return result;
//    }

}
