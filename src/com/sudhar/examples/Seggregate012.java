package com.sudhar.examples;

import java.util.Arrays;


public class Seggregate012 {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(final String[] args) {
        final int a[] = {0, 1, 2, 0, 1, 2};

        int low = 0, mid = 0, high = a.length - 1;

        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    swap(a, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a, mid, high);
                    high--;
                    break;
            }
        }
        System.out.println(Arrays.toString(a));

       // sort012(a, a.length);
    }

    static void sort012(int a[], int n)
    {
        int lo = 0;
        int hi = n - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }

}
