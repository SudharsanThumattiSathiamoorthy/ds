package com.sudhar.examples;

public class SubsetSumProblem {

    private static void subsetProblem(int[] a, int[] temp, int currSum, int targetSum, int i) {
        if (currSum == targetSum) {
            printArray(a, temp, i);
        } else if (i == a.length) {
            return;
        } else {
            temp[i] = 1;
            currSum += a[i];
            subsetProblem(a, temp, currSum, targetSum, i + 1);
            temp[i] = 0;
            currSum -= a[i];
            subsetProblem(a, temp, currSum, targetSum, i + 1);
        }
    }

    private static void printArray(int[] a, int[] temp, int k) {

        for (int i = 0; i < k; i++) {
            if (temp[i] == 1) {
                System.out.print(a[i]);
            }
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        int[] a = {3, 2, 7, 1, 5};
        subsetProblem(a, new int[a.length], 0, 6, 0);
    }
}
