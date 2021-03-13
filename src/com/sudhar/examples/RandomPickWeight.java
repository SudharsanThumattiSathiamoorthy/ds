package com.sudhar.examples;

import java.util.Random;

public class RandomPickWeight {
    private int[] probs;

    private int sum;

    private Random random = new Random();

    public RandomPickWeight(int[] w) {

        probs = new int[w.length];

        for (int  i = 0; i < w.length; i++) {
            sum += w[i];
            probs[i] = sum;
        }
    }

    public int pickIndex() {
        int next = random.nextInt(sum);

        return binarySearch(next+1);
    }

    private int binarySearch(int val) {
        int low = 0, high = probs.length -1;

        while (low < high) {
            int mid = low + (high - low) /2;

            if (probs[mid] == val) {
                return mid;
            } else if (probs[mid] < val) {
                low = mid +1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    class Solution1 {
        private int[] prefixSums;
        private int totalSum;

        public Solution1(int[] w) {
            this.prefixSums = new int[w.length];

            int prefixSum = 0;
            for (int i = 0; i < w.length; ++i) {
                prefixSum += w[i];
                this.prefixSums[i] = prefixSum;
            }
            this.totalSum = prefixSum;
        }

        public int pickIndex() {
            double target = this.totalSum * Math.random();

            // run a binary search to find the target zone
            int low = 0, high = this.prefixSums.length;
            while (low < high) {
                // better to avoid the overflow
                int mid = low + (high - low) / 2;
                if (target > this.prefixSums[mid])
                    low = mid + 1;
                else
                    high = mid;
            }
            return low;
        }
    }
}
