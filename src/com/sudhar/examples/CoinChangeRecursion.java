package com.sudhar.examples;

public class CoinChangeRecursion {

    static int[] coins = {1,2};
    static int amount = 4;
    public static void main(final String[] args) {


        System.out.println(computeCoinsCount(amount, 0));
    }

    private static int computeCoinsCount(int amount, int currentCoin) {

        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        int combinations = 0;
        for (int coin = currentCoin; coin < coins.length; coin++) {
            combinations += computeCoinsCount(amount - coins[coin], coin);
        }

        return combinations;
    }
}
