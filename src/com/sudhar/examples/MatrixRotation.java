package com.sudhar.examples;


public class MatrixRotation {

    public static void main(final String[] args) {
        int a[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };

        int N = a.length;

        for (int x= 0; x < N / 2; x++) {
            System.out.println("x: " + x + "\n");
            for (int y = x; y < N-1-x; y++ ) {
                System.out.println("y: " + y + "\n");
                int temp = a[x][y];
                a[x][y] = a[y][N-1-x];
                a[y][N-1-x] = a[N-1-x][N-1-y];
                a[N-1-x][N-1-y]=a[N-1-y][x];
                a[N-1-y][x]=temp;

                MatrixUtil.printMatrix(a);
                System.out.println();
            }
        }

        printArray(a);
    }

    private static void printArray(int[][] a) {
        for (int i = 0; i < a.length;i++) {
            for (int j= 0; j < a[0].length ;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


}
