package com.sudhar.examples;

import java.util.Arrays;

public class EqualPartitionSum {

    public static void main(String[] args) {

        System.out.println(canPartition(new int[]{1,5,11,5}));

    }

    private static boolean canPartition(int[] a) {
        if (a == null || a.length == 0) {
            return false;
        }

        int total = Arrays.stream(a).sum();

        if (total % 2 != 0) {
            return false;
        }

        return canPartition(a, 0, 0, total);
    }

    private static boolean canPartition(int[] a, int index, int sum, int total) {
        if (sum * 2  == total) {
            return true;
        }

        if (sum > total / 2 || index >= a.length) {
            return false;
        }

        return canPartition(a, index +1, sum, total) || canPartition(a, index + 1, sum + a[index], total);
    }
}
