package com.sudhar.examples;

public class EqualSumInArray {

    public static void main(final String[] args) {
        int a[] = {2, 3, 4, 1, 4};

        int result = findEqualSum(a);
        System.out.println("result : " + result);
    }

    private static int findEqualSum(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }

        if (a.length == 1) {
            return a[0];
        }

        int leftSum = 0, rightSum = 0;

        for (int i =1; i < a.length; i++) {
            rightSum += a[i];
        }

        for (int i =0, j=1; j< a.length; i++, j++) {
            rightSum -= a[j];

            leftSum += a[i];

            if (leftSum == rightSum) {
                return a[i+1];
            }
        }

        return -1;
    }
}
