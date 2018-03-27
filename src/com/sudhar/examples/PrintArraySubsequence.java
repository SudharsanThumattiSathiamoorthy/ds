package com.sudhar.examples;

public class PrintArraySubsequence {

    public static void main(final String[] args) {
        int [] a = {1, 2, 3};

        int temp[] = new int[a.length];
        buildSubsequence(a, 0, temp);
    }

    private static void buildSubsequence(int[] a, int i, int[] temp) {

        if (i == a.length) {
            printArray(a, temp);
        } else {
            temp[i] = 1;
            buildSubsequence(a, i+1, temp);
            temp[i] = 0;
            buildSubsequence(a, i+1, temp);
        }
    }

    private static void printArray(int[] a, int[] temp) {

        for (int i = 0; i < a.length;i++) {
            if (temp[i] == 1) {
                System.out.print(a[i]);
            }
        }
        System.out.println();
    }
}
