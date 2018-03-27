package com.sudhar.examples;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {

    public static void main(final String[] args) {
        int[] a = {1, 1, 2, 2, 2, 3, 3, 3, 3, 8, 8, 8};

        int i = 0, j = 1;

        while (j < a.length - 1) {
            while (a[i] == a[j] && j < a.length -1) {
                j++;
            }

            if (i < j && j < a.length - 1) {
                i++;
                a[i] = a[j];
                j++;
            }
        }

        System.out.println(i);

        System.out.println(Arrays.toString(Arrays.copyOf(a, i+1)));
    }
}
