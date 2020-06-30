package com.sudhar.examples;

public class StockProfitII {

    public static void main(String[] args) {
        StockProfitII stockProfitII = new StockProfitII();

        System.out.println(stockProfitII.findMaxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int findMaxProfit(int[] nos) {
        if (nos == null|| nos.length == 0) {
            return 0;
        }

        if (nos.length == 1) {
            return 0;
        }

        int profit = 0;

        for (int i = 1; i < nos.length; i++) {
            if (nos[i] > nos[i-1]) {
                profit += nos[i] - nos[i-1];
            }
        }

        return profit;
    }
}
