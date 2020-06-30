package com.sudhar.examples;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] a = {4,5,1, 8, 2};

        int[] left = new int[a.length];
        int[] right = new int[a.length];

        int[] result = new int[a.length];

        int len = a.length;

        left[0] = 1;
        right[len - 1] = 1;

        for(int i = 1; i < len; i++) {
            left[i] = left[i-1] * a[i-1];
        }

        for (int i = len -2; i >= 0; i--) {
            right[i] = right[i+1] * a[i+1];
        }

        for (int i = 0;i < len; i++) {
            result[i] = left[i] * right[i];
        }

        System.out.println(Arrays.toString(result));
    }

}
