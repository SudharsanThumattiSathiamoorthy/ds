package com.sudhar.examples;

public class KthSmallestElementInMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];

        while (lo <= hi) {
            int mi = lo + ((hi - lo) / 2);
            int count = countNonBigger(mi, matrix);

            System.out.println("mid: " + mi);
            System.out.println("count: " + count);

            if (count < k) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
            System.out.println("low : " + lo + " high: " + hi);
            System.out.println();
        }

        return lo;
    }

    private static int countNonBigger(int mi, int[][] matrix) {
        int n = matrix.length, i = n - 1, j = 0, cnt = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > mi) {
                i--;
            } else {
                cnt += i + 1;
                j++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

    }

}
