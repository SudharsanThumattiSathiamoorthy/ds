package com.sudhar.examples;

import java.util.Arrays;

public class ThreeSum {

    public static void main(final String[] args) {
        int a[] = { 1, 4, 45, 6, 10, 8 };

        threeSum(a, 22);
    }

    private static void threeSum(int[] a, int sum) {

        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {

            int l = i +1;
            int r = a.length - 1;

            while (l < r) {
                if (a[i] + a[l] + a[r] == sum) {
                    System.out.println("1 st: " + a[i] + ", 2 nd: " + a[l] + ", 3 rd: " + a[r]);
                    l++; r--;
                } else if (a[i] + a[l] + a[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }
}
