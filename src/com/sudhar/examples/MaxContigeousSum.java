package com.sudhar.examples;

public class MaxContigeousSum {

    public static void main(final String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};

        int max = 0, max_so_far = 0;

        for (int i = 0; i < a.length; i++) {
            max += a[i];
            if (max_so_far < max) {
                max_so_far = max;
            }
            if (max < 0) {
                max = 0;
            }
        }
        System.out.println(max_so_far);
    }
}
