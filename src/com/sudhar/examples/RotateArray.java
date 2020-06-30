package com.sudhar.examples;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7};

        int k = 3;

        k = k % a.length;

        rotateArray(a, 0, a.length-1);
        rotateArray(a, 0, k-1);
        rotateArray(a, k, a.length-1);

        System.out.println(Arrays.toString(a));
    }

    public static void rotateArray(int[] a, int start, int end) {
        while(start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }
}
