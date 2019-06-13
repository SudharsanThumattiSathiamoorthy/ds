package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintArraySubsequence {

    public static void main(final String[] args) {
        int [] a = {1, 2, 3};

        int temp[] = new int[a.length];
        // buildSubsequence(a, 0, "", temp);

        printAllCombinations(a, temp, "", 0);
    }

    private static void printAllCombinations(int[] a, int[] permute, String prefix, int ci) {
        System.out.println(prefix);

        for (int i = ci; i < a.length; i++) {
            int[] sub1 = Arrays.copyOfRange(a, 0, i);

            List list = new ArrayList<>();
            list.addAll(Arrays.asList(sub1));

            int sub2[] = Arrays.copyOfRange(a, i+1, a.length);
            list.addAll(Arrays.asList(sub2));

            Integer[] newArray = (Integer[]) list.toArray();

            int[] intArray = Arrays.stream(newArray).mapToInt(Integer::intValue).toArray();

            String tempPrefix = prefix + a[i];

            printAllCombinations(intArray, permute, tempPrefix, i);
        }
    }

//    private static void buildSubsequence(int[] a, int i, int[] temp) {
//
//        if (i == a.length) {
//            printArray(a, temp);
//        } else {
//            temp[i] = 1;
//            buildSubsequence(a, i+1, temp);
//            temp[i] = 0;
//            buildSubsequence(a, i+1, temp);
//        }
//    }
//
//    private static void printArray(int[] a, int[] temp) {
//
//        for (int i = 0; i < a.length;i++) {
//            if (temp[i] == 1) {
//                System.out.print(a[i]);
//            }
//        }
//        System.out.println();
//    }
}
