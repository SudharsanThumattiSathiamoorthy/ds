package com.sudhar.examples;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;

public class Seggregate01 {

    public static void main(final String[] args) {
        int a[] = {0, 1, 1, 0, 1, 1, 0};

        int l = 0, h = a.length - 1;

        while (l < h) {
            while (a[l] == 0) {
                l++;
            }

            while (a[h] == 1) {
                h--;
            }

            if (l < h) {
                swap(a, l, h);
                l++;
                h--;
            }
        }

        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
