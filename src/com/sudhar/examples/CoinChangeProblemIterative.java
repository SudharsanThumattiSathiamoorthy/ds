package com.sudhar.examples;

import java.util.Arrays;

public class CoinChangeProblemIterative {

    static int coins[] = {1, 2, 3};
    static int amount = 4;

    public static void main(final String[] args) {

        System.out.println(Arrays.toString(coins));

        computeNoOfCombinations();
    }

    private static void computeNoOfCombinations() {

        int combination[] = new int[amount + 1];

        combination[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i] ; j < combination.length ; j++) {
                combination[j] += combination[j-coins[i]];
                System.out.println(Arrays.toString(combination));
            }
        }
        System.out.println(combination[combination.length-1]);
    }
}
