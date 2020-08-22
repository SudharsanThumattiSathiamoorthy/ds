package com.sudhar.examples;

import java.util.Arrays;

public class DistributeCandies {

    public int[] distributeCandies(int candies, int numberOfPeople) {

        int[] result = new int[numberOfPeople];

        int idx = 0, candies_count = 1;
        while (candies > 0) {

            result[idx++] += candies_count;
            candies -= candies_count++;

            if (idx == numberOfPeople) {
                idx = 0;
            }

            if (candies_count > candies) {
                candies_count = candies;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DistributeCandies dc = new DistributeCandies();

        System.out.println(Arrays.toString(dc.distributeCandies(7, 4)));
    }
}
