package com.sudhar.examples;

import java.util.Arrays;

public class InplaceStringPermutation {

    public static void main(final String[] args) {

        char[] ip = "abc ".toCharArray();

        permute(ip, 0, ip.length);
    }

    private static void permute(char[] a, int l, int r) {
        if (l == r) {
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = l; i < r; i++) {
                swap(a, i, l);
                permute(a, l+1, r);
                swap(a, i, l);
            }
        }
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
