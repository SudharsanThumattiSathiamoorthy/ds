package com.sudhar.examples;

public class CountCoins {

    public static void main(final String[] args) {
        int a[] = {1,2,3};

        System.out.println(coinsChange(a, a.length-1, 4));
    }

    private static int coinsChange(int[] a, int m, int n) {

        // One solution exists, return 1.
        if (n == 0) {
            return 1;
        }

        // value has gone down 0, no solution exists.
        if (n < 0) {
            return 0;
        }

        // we are out of no's, so no solution exists.
        if (m <=0 && n >=1) {
            return 0;
        }

        return coinsChange(a, m-1, n) + coinsChange(a, m, n-a[m-1]);
    }

}
