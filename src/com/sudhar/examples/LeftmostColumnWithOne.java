package com.sudhar.examples;

public class LeftmostColumnWithOne {

    public static void main(String[] args) {
        int[][] a = {
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
        };

        int rowLen = a.length;
        int columnLen = a[0].length;

        int r = 0, c = columnLen - 1;
        int result  = -1;
        while (r < rowLen && c >= 0) {
            if (a[r][c] == 1) {
                result = c;
                c--;
            } else {
                r++;
            }
        }

        System.out.println("result is : " + result);
    }
}
