package com.sudhar.examples;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        int a1[] = {1, 2, 3, 5, 7};
        int a2[] = {2, 4, 6};

        System.out.println(Arrays.toString(mergeTwoArrays(a1, a2)));
    }

    public static int[] mergeTwoArrays(int[] a1, int[] a2) {
        if (a1 == null && a2  == null) {
            return null;
        }

        if (a1 == null) {
            return a2;
        }

        if (a2 == null) {
            return a1;
        }

        int i = a1.length-1, j = a2.length-1;

        a1 = Arrays.copyOf(a1, a1.length + a2.length);

        int a1Size = a1.length - 1;

        while (i >= 0 && j >= 0) {
            if (a2[j] >= a1[i]) {
                a1[a1Size--] = a2[j];
                j--;
            } else {
                a1[a1Size--] = a1[i];
                i--;
            }
        }

        return a1;
    }
}
