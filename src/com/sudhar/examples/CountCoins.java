package com.sudhar.examples;

public class CountCoins {

    public static void main(final String[] args) {
        int coins[] = {1, 2, 5};

        System.out.println(coinsChange(coins, coins.length, 5));
    }

    private static int coinsChange(int[] a, int ci, int amount) {
        // One solution exists, return 1.
        if (amount == 0) {
            return 1;
        }

        // value has gone down 0, no solution exists.
        if (amount < 0) {
            return 0;
        }

        // we are out of no's, so no solution exists.
        if (ci <= 0 && amount >= 1) {
            return 0;
        }

        return coinsChange(a, ci - 1, amount) + coinsChange(a, ci, amount - a[ci - 1]);
    }

}
