package com.sudhar.examples;

public class NoOfIslands {

    public static void main(String[] args) {

    }

    private int noOfIslands(char[][] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int count = 0, row = 0, col = a[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == '1') {
                }
            }
        }
        return 0;
    }
}
