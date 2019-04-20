package com.sudhar.examples;

public class LongestIncreasingSubsequence {

    public static void main(final String[] args) {
        int arr[] = {10, 22, 9, 33,};

        findLIS(arr);
    }

    private static void findLIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.err.println("Array is empty");
        }

        int lis[] = new int[arr.length];
        int i, j, max = lis[0];

        for (i = 0; i < arr.length - 1; i++) {
            lis[i] = 1;
        }

        for (i = 1; i < arr.length; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    max = lis[i] > max ? lis[i] : max;
                }
            }
        }

        System.out.println(max);
    }
}
