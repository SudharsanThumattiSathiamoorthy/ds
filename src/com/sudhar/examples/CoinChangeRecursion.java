package com.sudhar.examples;

public class CoinChangeRecursion {

    static int[] coins = {1,2};
    static int amount = 4;
    public static void main(final String[] args) {


        System.out.println(computeCoinsCount(amount, 0));
    }


    private static int computeCoinsCount(int amount, int currentIndex) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        int coinsCount = 0;
        for(int i = currentIndex; i < coins.length; i++) {
            coinsCount += computeCoinsCount(amount - coins[i], currentIndex);
        }
        return coinsCount;
    }
}
