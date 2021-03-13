package com.sudhar.examples;

public class CustomRandomFunction {

//    Example:
//
//            3 cities
//    populations are 2, 3, and 5
//    probs[] = 0.2, 0.5, 1
//    you get a random value, d. d is between 0 and 1
//            if d < 0.2 => res = 0
//            if d < 0.5=> res = 1
//            else res = 2
    private final int[] cityCode;

    private double[] probs;

    CustomRandomFunction(int[] cityCode, int[] population) {
        this.cityCode = cityCode;
        probs = new double[cityCode.length];

        double total = 0.d;
        for (int x : population) {
            total += x;
        }
        probs[0] = population[0] / total;
        for (int i = 1; i < population.length; i++) {
            probs[i] = probs[i - 1] + population[i] / total;
        }
    }

    public int nextInt() {
        final double d = Math.random();
        // use binary search
        int low = 0;
        int high = this.probs.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (probs[mid] == d)
                return this.cityCode[mid];
            else if (probs[mid] < d && mid != low)
                low = mid;
            else if (probs[mid] > d && mid != high)
                high = mid;
            else
                // terminate with index pointing to the first element greater
                // than low
                high = low = low + 1;
        }

        return this.cityCode[low];
    }

    public static void main(String[] args) {
        int[] codes = { 0, 1, 2, 3, 4, 5 };
        int[] pops = { 10, 3, 4, 6, 13, 8 };
        var rand = new CustomRandomFunction(codes, pops);
        for (int i = 0; i < 10; i++) {
            var res = rand.nextInt();
            System.out.println(res);
        }
    }

}
