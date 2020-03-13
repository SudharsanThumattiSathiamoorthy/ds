package com.sudhar.examples;

import java.util.HashSet;
import java.util.Set;

public class SumPairFromTwoArrays {

    public static void main(String[] args) {
        System.out.println(findSumPair(new int[] {0, 0, -5, 30212}, new int[] {-10, 40, -3, 9}, 10));
    }

    private static boolean findSumPair(int[] a, int[] b, int target) {
        Set<Integer> diff = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            int difference = target - a[i];

            diff.add(difference);
        }

        for (int j = 0; j < b.length; j++) {
           if (diff.contains(b[j])) {
               return true;
           }
        }

        return false;
    }
}
